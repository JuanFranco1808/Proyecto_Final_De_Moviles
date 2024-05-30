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
import com.example.proyecto2.databinding.ActivityRegisterSuppliesBinding

class RegisterSupplies : AppCompatActivity(), View.OnClickListener {
    lateinit var binding : ActivityRegisterSuppliesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterSuppliesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnRegisterSupply.setOnClickListener(this)
        binding.btnListSupply.setOnClickListener(this)
        binding.btnBackSupply.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btnRegisterSupply -> {
                Toast.makeText(this, "Insumo registrado", Toast.LENGTH_LONG).show()
            }
            R.id.btnListSupply -> {
                val intent = Intent(this, ViewList::class.java)
                startActivity(intent)
            }
            R.id.btnBackSupply -> {
                val intent = Intent(this, MainMenu::class.java)
                startActivity(intent)
            }
        }
    }
}