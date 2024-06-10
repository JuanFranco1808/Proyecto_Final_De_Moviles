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
import com.example.proyecto2.adapters.VehicleAdapter
import com.example.proyecto2.adapters.SupplieAdapter
import com.example.proyecto2.databinding.ActivityViewListBinding
import com.example.proyecto2.models.Clients
import com.example.proyecto2.models.Vehicles
import com.example.proyecto2.models.Supplies
import com.example.proyecto2.models.Globals
import com.example.proyecto2.models.database.entities.ClientEntity
import com.example.proyecto2.models.database.entities.VehicleEntity
import com.example.proyecto2.models.database.entities.SupplieEntity

class ViewList : AppCompatActivity(), View.OnClickListener {
    lateinit var binding : ActivityViewListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnBackList.setOnClickListener(this)
        if (intent.getStringExtra("tipo") == "client") {
            var clients: Clients = Clients(Globals.getDatabase(this)?.clientDao()?.getAllClients()!! as ArrayList<ClientEntity>)
            var adapter : ClientAdapter = ClientAdapter(this, clients)
            binding.ListView.adapter = adapter
        }
        if (intent.getStringExtra("tipo") == "vehicle") {
            var vehicles : Vehicles = Vehicles(Globals.getDatabase(this)?.vehicleDao()?.getAllVehicles()!! as ArrayList<VehicleEntity>)
            var adapter : VehicleAdapter = VehicleAdapter(this, vehicles)
            binding.ListView.adapter = adapter
        }
        if (intent.getStringExtra("tipo") == "supplie") {
            var supplies : Supplies = Supplies(Globals.getDatabase(this)?.supplieDao()?.getAllSupplies()!! as ArrayList<SupplieEntity>)
            var adapter : SupplieAdapter = SupplieAdapter(this, supplies)
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