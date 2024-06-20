package com.example.proyecto2.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyecto2.R
import com.example.proyecto2.databinding.ActivityMainBinding
import com.example.proyecto2.models.Globals
import com.example.proyecto2.models.database.entities.UserEntity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Globals.initDatabase(this)
        binding.btnSignIn.setOnClickListener(this)
        binding.btnSignUp.setOnClickListener(this)
        val userLog = Globals.getSharePreferenceName(this)
        if (userLog != "") {
            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
        }
    }
    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btnSignIn -> {
                var cedula = binding.txtCedula.text.toString()
                var password = binding.txtPassword.text.toString()
                var user = Globals.getDatabase(this)?.userDao()?.getUserByCedulaAndPassword(cedula, password)

                if (user != null) {
                    Toast.makeText(this, "Bienvenido " + user.name.toString(), Toast.LENGTH_LONG).show()
                    Globals.addSharePreference(this,user)
                    val intent = Intent(this, MainMenu::class.java)
                    startActivity(intent)
                }
                else {
                    binding.txtCedula.setText("")
                    binding.txtPassword.setText("")
                    Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_LONG).show()
                }
            }
            R.id.btnSignUp -> {
                val intent = Intent(this, RegisterUser::class.java)
                startActivity(intent)
            }
        }
    }
}