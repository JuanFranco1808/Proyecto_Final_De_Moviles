package com.example.proyecto2.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
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
        // Lista de roles para el spinner
        val roles = listOf("User","Admin")
        // Crear un adaptador para el spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, roles)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Asignar el adaptador al spinner usando View Binding
        binding.spinnerRoleUser.adapter = adapter
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btnSignInUser -> {
                var user = UserEntity()
                user.name = binding.txtNameUser.text.toString()
                user.cedula = binding.txtCedulaUser.text.toString()
                user.password = binding.txtPasswordUser.text.toString()
                //user.roll = binding.txtRoleUser.text.toString()
                user.roll = binding.spinnerRoleUser.selectedItem.toString()
                Globals.getDatabase(this)?.userDao()?.insertUser(user)
                Globals.listaUsers.users.add(user)
                var usernew = Globals.getDatabase(this)?.userDao()?.getUserByCedulaAndPassword(user.cedula, user.password)
                Globals.addSharePreference(this,usernew!!)
                Toast.makeText(this, "Registro exitoso", Toast.LENGTH_LONG).show()
                clearFields()
                val intent = Intent(this, MainMenu::class.java)
                startActivity(intent)
            }
        }
    }
    private fun clearFields() {
        binding.txtNameUser.setText("")
        binding.txtCedulaUser.setText("")
        binding.txtPasswordUser.setText("")
    }
}