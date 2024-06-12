package com.example.proyecto2.views
import android.text.method.ScrollingMovementMethod
import android.content.Intent
import android.os.Bundle
import android.telecom.Call.Details
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyecto2.R
import com.example.proyecto2.databinding.ActivityRegisterSaleBinding
import com.example.proyecto2.models.Clients
import com.example.proyecto2.models.Vehicles
import com.example.proyecto2.models.Supplies
import com.example.proyecto2.models.Globals
import com.example.proyecto2.models.database.entities.ClientEntity
import com.example.proyecto2.models.database.entities.SaleEntity
import com.example.proyecto2.models.database.entities.SaleDetailEntity
import com.example.proyecto2.models.database.entities.VehicleEntity
import com.example.proyecto2.models.database.entities.SupplieEntity
import java.math.BigDecimal

class RegisterSale : AppCompatActivity(), View.OnClickListener{
    lateinit var binding : ActivityRegisterSaleBinding
    private val clientesMap = mutableMapOf<String, Int>()
    private val suppliesMap = mutableMapOf<String, Int>()
    private val vehiclesMap = mutableMapOf<String, Int>()
    private var clients: Clients = Clients(Globals.getDatabase(this)?.clientDao()?.getAllClients()!! as ArrayList<ClientEntity>)
    private val supplies: Supplies = Supplies(Globals.getDatabase(this)?.supplieDao()?.getAllSupplies()!! as ArrayList<SupplieEntity>)
    private var vehicles: Vehicles = Vehicles(Globals.getDatabase(this)?.vehicleDao()?.getAllVehicles()!! as ArrayList<VehicleEntity>)
    private var text ="Articulos: \n"
    private var totalSale = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterSaleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAddProductSale.setOnClickListener(this)
        binding.btnRegisterSale.setOnClickListener(this)
        binding.btnListSale.setOnClickListener(this)
        binding.btnBackSale.setOnClickListener(this)
        binding.txtResumenSale.movementMethod = ScrollingMovementMethod()
        val types = listOf("Vehiculo","Insumo")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, types)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerType.adapter = adapter

        clientesMap.clear()
        clientesMap.putAll(clients.clients.associate { "${it.name}; NIT:${it.nit}" to it.id })
        val clientsView= clientesMap.keys.toList()
        val adapterClient = ArrayAdapter(this, android.R.layout.simple_spinner_item, clientsView)
        adapterClient.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.autoCompleteTextViewClient.setAdapter(adapterClient)

        suppliesMap.clear()
        suppliesMap.putAll(supplies.supplies.associate { "${it.name}; REF: ${it.reference}" to it.id })
        val suppliesView = suppliesMap.keys.toList()
        val adapterSupplie = ArrayAdapter(this, android.R.layout.simple_spinner_item, suppliesView)
        adapterSupplie.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        vehiclesMap.clear()
        vehiclesMap.putAll(vehicles.vehicles.associate { "${it.brand}; MOD: ${it.model}" to it.id })
        val vehiclesView = vehiclesMap.keys.toList()
        val adapterVehicle= ArrayAdapter(this, android.R.layout.simple_spinner_item, vehiclesView)
        adapterVehicle.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spinnerType.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedType = parent.getItemAtPosition(position).toString()
                if (selectedType == "Vehiculo") {
                    binding.autoCompleteTextViewProduct.setAdapter(adapterVehicle)
                } else {
                    binding.autoCompleteTextViewProduct.setAdapter(adapterSupplie)
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        })

    }


    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btnAddProductSale -> {
                val selectProduct = binding.autoCompleteTextViewProduct.text.toString()
                val cantidad = binding.txtProductQuantitySale.text.toString()
                if (selectProduct == "") {
                    Toast.makeText(this, "Seleccione un producto", Toast.LENGTH_LONG).show()
                    return
                }
                if (cantidad == "" || cantidad.toInt() == 0){
                    Toast.makeText(this, "Ingrese una cantidad valida", Toast.LENGTH_LONG).show()
                    return
                }
                if (binding.autoCompleteTextViewClient.text.toString() == "") {
                    Toast.makeText(this, "Seleccione un cliente", Toast.LENGTH_LONG).show()
                    return
                }
                var type = binding.spinnerType.selectedItem.toString()
                var precio = 0.0
                if (type == "Vehiculo") {
                    val VehicleId = vehiclesMap[selectProduct]
                    text = text + "-Vehiculo: $selectProduct"
                    precio = vehicles.vehicles.find { it.id == VehicleId }!!.price
                } else {
                    val SupplieId = suppliesMap[selectProduct]
                    text = text + "-Insumo: $selectProduct"
                    precio = supplies.supplies.find { it.id == SupplieId }!!.price
                }
                var total = BigDecimal(precio * cantidad.toDouble()).toPlainString()
                totalSale += total.toDouble()
                text  = text + " Cantidad: $cantidad Total: $total \n"
                text.also { binding.txtResumenSale.text = it }
                binding.textEtiquetaTotal.text = "Total:"
                binding.textTotal.text = BigDecimal(totalSale).toPlainString()
                clearFields()
                binding.autoCompleteTextViewClient.isEnabled = false
                binding.autoCompleteTextViewClient.inputType = 0
                var saleDetailEntity = SaleDetailEntity()
                saleDetailEntity.itemType = type
                saleDetailEntity.price = total.toDouble()
                saleDetailEntity.quantity = cantidad.toInt()
                saleDetailEntity.idSale = 0
                Globals.listaSaleDetails.saleDetails.add(saleDetailEntity)
                Toast.makeText(this, "Producto añadido", Toast.LENGTH_LONG).show()
            }
            R.id.btnRegisterSale -> {
                var sale = SaleEntity()
                sale.total = totalSale
                sale.date = System.currentTimeMillis().toString()
                sale.idClient = clientesMap[binding.autoCompleteTextViewClient.text.toString()]!!
                var id = Globals.getSharePreferenceId(this)
                sale.idUser = id.toInt()
                Globals.getDatabase(this)?.saleDao()?.insertSale(sale)
                var idSale = Globals.getDatabase(this)?.saleDao()?.getSaleByDate(sale.date)!!.id
                Globals.listaSales.sales.add(sale)
                for (saleDetail in Globals.listaSaleDetails.saleDetails) {
                    saleDetail.idSale = idSale
                    Globals.getDatabase(this)?.saleDetailDao()?.insertSaleDetail(saleDetail)
                }
                Globals.listaSaleDetails.saleDetails.clear()
                binding.txtResumenSale.text = ""
                binding.autoCompleteTextViewClient.isEnabled = true
                binding.autoCompleteTextViewClient.inputType = 1
                Toast.makeText(this, "Venta registrada", Toast.LENGTH_LONG).show()
            }
            R.id.btnListSale -> {
                val intent = Intent(this, ViewList::class.java)
                startActivity(intent)
            }
            R.id.btnBackSale -> {
                val intent = Intent(this, MainMenu::class.java)
                startActivity(intent)
            }
        }
    }
    private fun clearFields() {
        binding.autoCompleteTextViewProduct.setText("")
        binding.txtProductQuantitySale.setText("")
    }
}