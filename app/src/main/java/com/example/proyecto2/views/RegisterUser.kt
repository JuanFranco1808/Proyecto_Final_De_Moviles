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
import com.example.proyecto2.databinding.ActivityRegisterUserBinding

class RegisterUser : AppCompatActivity(), View.OnClickListener{
    lateinit var binding : ActivityRegisterUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSignInUser.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btnSignInUser -> {
                val intent = Intent(this, MainMenu::class.java)
                Toast.makeText(this, "Registro exitoso", Toast.LENGTH_LONG).show()
                startActivity(intent)
            }
        }
    }
}