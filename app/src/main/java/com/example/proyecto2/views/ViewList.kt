package com.example.proyecto2.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyecto2.R
import com.example.proyecto2.adapters.ClientAdapter
import com.example.proyecto2.adapters.SaleAdapter
import com.example.proyecto2.adapters.SaleDetailsAdapter
import com.example.proyecto2.adapters.VehicleAdapter
import com.example.proyecto2.adapters.SupplieAdapter
import com.example.proyecto2.databinding.ActivityViewListBinding
import com.example.proyecto2.models.Clients
import com.example.proyecto2.models.Vehicles
import com.example.proyecto2.models.Supplies
import com.example.proyecto2.models.Sales
import com.example.proyecto2.models.SaleDetails
import com.example.proyecto2.models.Globals
import com.example.proyecto2.models.database.entities.ClientEntity
import com.example.proyecto2.models.database.entities.VehicleEntity
import com.example.proyecto2.models.database.entities.SupplieEntity
import com.example.proyecto2.models.database.entities.SaleEntity
import com.example.proyecto2.models.database.entities.SaleDetailEntity
class ViewList : AppCompatActivity(), View.OnClickListener {
    lateinit var binding : ActivityViewListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnBackList.setOnClickListener(this)
        var roll = Globals.getSharePreferenceRoll(this)
        if (intent.getStringExtra("tipo") == "client") {
            var clients: Clients
            if (roll == "Admin") {
                clients = Clients(Globals.getDatabase(this)?.clientDao()?.getAllClients()!! as ArrayList<ClientEntity>)
            } else {
                var id = Globals.getSharePreferenceId(this)
                clients = Clients(Globals.getDatabase(this)?.clientDao()?.getAllClientsByUserId(id)!! as ArrayList<ClientEntity>)
            }
            var adapter : ClientAdapter = ClientAdapter(this, clients)
            binding.ListView.adapter = adapter
        }
        if (intent.getStringExtra("tipo") == "vehicle") {
            var vehicles : Vehicles
            if (roll == "Admin") {
                vehicles = Vehicles(Globals.getDatabase(this)?.vehicleDao()?.getAllVehicles()!! as ArrayList<VehicleEntity>)
            } else {
                var id = Globals.getSharePreferenceId(this)
                vehicles = Vehicles(Globals.getDatabase(this)?.vehicleDao()?.getAllVehiclesByUserId(id)!! as ArrayList<VehicleEntity>)
            }
            var adapter : VehicleAdapter = VehicleAdapter(this, vehicles)
            binding.ListView.adapter = adapter
        }
        if (intent.getStringExtra("tipo") == "supplie") {
            var supplies : Supplies
            if (roll == "Admin") {
                supplies = Supplies(Globals.getDatabase(this)?.supplieDao()?.getAllSupplies()!! as ArrayList<SupplieEntity>)
            } else {
                var id = Globals.getSharePreferenceId(this)
                supplies = Supplies(Globals.getDatabase(this)?.supplieDao()?.getAllSuppliesByUserId(id)!! as ArrayList<SupplieEntity>)
            }
            var adapter : SupplieAdapter = SupplieAdapter(this, supplies)
            binding.ListView.adapter = adapter
        }
        if (intent.getStringExtra("tipo") == "sale") {
            var sales : Sales
            if (roll == "Admin") {
                sales = Sales(Globals.getDatabase(this)?.saleDao()?.getAllSales()!! as ArrayList<SaleEntity>)
            } else {
                var id = Globals.getSharePreferenceId(this)
                sales = Sales(Globals.getDatabase(this)?.saleDao()?.getAllSalesByUserId(id)!! as ArrayList<SaleEntity>)
            }
            var adapter : SaleAdapter = SaleAdapter(this, sales)
            binding.ListView.adapter = adapter
        }
        if (intent.getStringExtra("tipo") == "saleDetails") {
            var id = intent.getIntExtra("id" , 0).toInt()
            var saleDetails : SaleDetails = SaleDetails(Globals.getDatabase(this)?.saleDetailDao()?.getSaleDetailsBySaleId(id)!! as ArrayList<SaleDetailEntity>)
            var adapter : SaleDetailsAdapter = SaleDetailsAdapter(this, saleDetails)
            binding.ListView.adapter = adapter
        }
    }
    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btnBackList -> {
                val intent = Intent(this, MainMenu::class.java)
                startActivity(intent)
            }
        }
    }
}