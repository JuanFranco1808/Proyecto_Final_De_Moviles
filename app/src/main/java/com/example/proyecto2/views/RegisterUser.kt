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
import com.example.proyecto2.models.Globals
import com.example.proyecto2.models.database.entities.UserEntity

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
                var user = UserEntity()
                user.name = binding.txtNameUser.text.toString()
                user.cedula = binding.txtCedulaUser.text.toString()
                user.password = binding.txtPasswordUser.text.toString()
                user.roll = binding.txtRoleUser.text.toString()
                Globals.getDatabase(this)?.userDao()?.insertUser(user)
                Globals.listaUsers.users.add(user)
                Globals.addSharePreference(this,user)
                Toast.makeText(this, "Se ha agregado una persona", Toast.LENGTH_LONG).show()
                clearFields()
                val intent = Intent(this, MainMenu::class.java)
                Toast.makeText(this, "Registro exitoso", Toast.LENGTH_LONG).show()
                startActivity(intent)
            }
        }
    }
    private fun clearFields() {
        binding.txtNameUser.setText("")
        binding.txtCedulaUser.setText("")
        binding.txtPasswordUser.setText("")
        binding.txtRoleUser.setText("")
    }
}