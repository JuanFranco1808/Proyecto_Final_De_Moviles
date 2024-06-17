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
import com.example.proyecto2.databinding.ActivityMainMenuBinding
import com.example.proyecto2.models.Globals
class MainMenu : AppCompatActivity(), View.OnClickListener {
    lateinit var binding : ActivityMainMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSignOut.setOnClickListener(this)
        binding.btnClients.setOnClickListener(this)
        binding.btnVehicles.setOnClickListener(this)
        binding.btnSupplies.setOnClickListener(this)
        binding.btnSales.setOnClickListener(this)
        var texto = Globals.getSharePreferenceName(this)
        var rol = Globals.getSharePreferenceRoll(this)
        texto = texto + "\n" + rol
        binding.txtViewName.text = texto
    }
    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btnSignOut -> {
                val intent = Intent(this, MainActivity::class.java)
                Toast.makeText(this, "Cerrando sesion", Toast.LENGTH_LONG).show()
                startActivity(intent)
            }
            R.id.btnClients -> {
                if(rolValidation()) {
                    val intent = Intent(this, RegisterClient::class.java)
                    startActivity(intent)
                }
            }
            R.id.btnVehicles -> {
                if (rolValidation()) {
                    val intent = Intent(this, RegisterVehicle::class.java)
                    startActivity(intent)
                }
            }
            R.id.btnSupplies -> {
                if (rolValidation()) {
                    val intent = Intent(this, RegisterSupplies::class.java)
                    startActivity(intent)
                }
            }
            R.id.btnSales -> {
                val intent = Intent(this, RegisterSale::class.java)
                startActivity(intent)
            }
        }
    }
    private fun rolValidation(): Boolean {
        val rol = Globals.getSharePreferenceRoll(this)
        if (rol=="Admin"){
            return true
        }
        else if (rol=="User"){
            return true
        }
        else {
            Toast.makeText(this, "Acceso denegado", Toast.LENGTH_LONG).show()
        }
        return false
    }
}