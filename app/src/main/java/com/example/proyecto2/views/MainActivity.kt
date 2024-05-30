package com.example.proyecto2.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyecto2.R
import com.example.proyecto2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSignIn.setOnClickListener(this)
        binding.btnSignUp.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btnSignIn -> {
                val intent = Intent(this, MainMenu::class.java)
                startActivity(intent)
            }
            R.id.btnSignUp -> {
                val intent = Intent(this, RegisterUser::class.java)
                startActivity(intent)
            }
        }
    }
}