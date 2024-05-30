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
import com.example.proyecto2.databinding.ActivityRegisterSaleBinding

class RegisterSale : AppCompatActivity(), View.OnClickListener {
    lateinit var binding : ActivityRegisterSaleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterSaleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAddProductSale.setOnClickListener(this)
        binding.btnRegisterSale.setOnClickListener(this)
        binding.btnListSale.setOnClickListener(this)
        binding.btnBackSale.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btnAddProductSale -> {
                Toast.makeText(this, "Producto añadido", Toast.LENGTH_LONG).show()
            }
            R.id.btnRegisterSale -> {
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
}