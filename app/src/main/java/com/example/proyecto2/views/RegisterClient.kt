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
import com.example.proyecto2.databinding.ActivityRegisterClientBinding

class RegisterClient : AppCompatActivity(), View.OnClickListener {
    lateinit var binding : ActivityRegisterClientBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterClientBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnRegisterClient.setOnClickListener(this)
        binding.btnListClient.setOnClickListener(this)
        binding.btnBackClient.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btnRegisterClient -> {
                Toast.makeText(this, "Cliente registrado", Toast.LENGTH_LONG).show()
            }
            R.id.btnListClient -> {
                val intent = Intent(this, ViewList::class.java)
                startActivity(intent)
            }
            R.id.btnBackClient -> {
                val intent = Intent(this, MainMenu::class.java)
                startActivity(intent)
            }
        }
    }
}