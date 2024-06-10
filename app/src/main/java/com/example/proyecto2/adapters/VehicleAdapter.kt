package com.example.proyecto2.adapters
import android.content.Context
import android.widget.BaseAdapter
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.proyecto2.models.Vehicles
import com.example.proyecto2.models.database.entities.VehicleEntity
import com.example.proyecto2.R
import com.example.proyecto2.models.Globals
import java.math.BigDecimal

class VehicleAdapter : BaseAdapter {
    var context : Context
    var vehicles : Vehicles
    constructor(context : Context, vehicles: Vehicles){
        this.context = context
        this.vehicles = vehicles
    }
    override fun getCount(): Int {
        return vehicles.vehicles.size
    }
    override fun getItem(p0: Int): Any {
        return vehicles.vehicles[p0]
    }
    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View? {
        var view: View? = p1
        if (view == null) {
            view = View.inflate(context, R.layout.item_adapter, null)
        }
        var vehicle = vehicles.vehicles[p0]
        var id = view?.findViewById<TextView>(R.id.txtId)
        id?.text = vehicle.id.toString()
        var dato1 = view?.findViewById<TextView>(R.id.txtDato1)
        dato1?.text = "Marca: " + vehicle.brand
        var dato2 = view?.findViewById<TextView>(R.id.txtDato2)
        dato2?.text = "Modelo: " + vehicle.model
        var dato3 = view?.findViewById<TextView>(R.id.txtDato3)
        val precio = BigDecimal(vehicle.price).toPlainString()
        dato3?.text = "Precio: " + precio
        var dato4 = view?.findViewById<TextView>(R.id.txtDato4)
        var userName = Globals.getDatabase(context)?.userDao()?.getUserNameById(vehicle.idUser)
        dato4?.text = "Usuario: " + userName
        return view
    }
}