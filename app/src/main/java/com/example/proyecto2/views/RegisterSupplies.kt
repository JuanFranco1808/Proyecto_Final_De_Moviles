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
import com.example.proyecto2.models.Globals
import com.example.proyecto2.models.database.entities.SupplieEntity

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
                var supplie = SupplieEntity()
                supplie.reference = binding.txtReferenceSupply.text.toString()
                supplie.name = binding.txtNameSupply.text.toString()
                supplie.price = binding.txtPriceSupply.text.toString().toDouble()
                var id = Globals.getSharePreferenceId(this)
                supplie.idUser = id.toInt()
                Globals.getDatabase(this)?.supplieDao()?.insertSupplie(supplie)
                Globals.listaSupplies.supplies.add(supplie)
                clearFields()
                Toast.makeText(this, "Insumo registrado", Toast.LENGTH_LONG).show()
            }
            R.id.btnListSupply -> {
                val intent = Intent(this, ViewList::class.java)
                intent.putExtra("tipo", "supplie")
                startActivity(intent)
            }
            R.id.btnBackSupply -> {
                val intent = Intent(this, MainMenu::class.java)
                startActivity(intent)
            }
        }
    }
    private fun clearFields() {
        binding.txtNameSupply.setText("")
        binding.txtReferenceSupply.setText("")
        binding.txtPriceSupply.setText("")
    }
}