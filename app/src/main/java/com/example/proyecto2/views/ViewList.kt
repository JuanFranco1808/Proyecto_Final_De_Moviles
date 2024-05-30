package com.example.proyecto2.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyecto2.R
import com.example.proyecto2.databinding.ActivityViewListBinding

class ViewList : AppCompatActivity(), View.OnClickListener {
    lateinit var binding : ActivityViewListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnBackList.setOnClickListener(this)
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