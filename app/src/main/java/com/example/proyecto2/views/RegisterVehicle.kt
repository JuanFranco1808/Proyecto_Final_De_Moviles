package com.example.proyecto2.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyecto2.R
import com.example.proyecto2.databinding.ActivityRegisterVehicleBinding
import com.example.proyecto2.models.Globals
import com.example.proyecto2.models.database.entities.VehicleEntity

class RegisterVehicle : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityRegisterVehicleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterVehicleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnRegisterVehicle.setOnClickListener(this)
        binding.btnListVehicle.setOnClickListener(this)
        binding.btnBackVehicle.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnRegisterVehicle -> {
                var vehicle = VehicleEntity()
                vehicle.brand = binding.txtBrandVehicle.text.toString()
                vehicle.model = binding.txtModelVehicle.text.toString()
                vehicle.price = binding.txtPriceVehicle.text.toString().toDouble()
                var id = Globals.getSharePreferenceId(this)
                vehicle.idUser = id.toInt()
                Globals.getDatabase(this)?.vehicleDao()?.insertVehicle(vehicle)
                Globals.listaVehicles.vehicles.add(vehicle)
                clearFields()
                Toast.makeText(this, "Vehiculo registrado", Toast.LENGTH_LONG).show()
            }

            R.id.btnListVehicle -> {
                val intent = Intent(this, ViewList::class.java)
                intent.putExtra("tipo", "vehicle")
                startActivity(intent)
            }

            R.id.btnBackVehicle -> {
                val intent = Intent(this, MainMenu::class.java)
                startActivity(intent)
            }
        }

    }
    private fun clearFields() {
        binding.txtBrandVehicle.setText("")
        binding.txtModelVehicle.setText("")
        binding.txtPriceVehicle.setText("")
    }
}
