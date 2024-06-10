package com.example.proyecto2.adapters
import android.content.Context
import android.widget.BaseAdapter
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.proyecto2.models.Supplies
import com.example.proyecto2.models.database.entities.SupplieEntity
import com.example.proyecto2.R
import com.example.proyecto2.models.Globals
import java.math.BigDecimal

class SupplieAdapter : BaseAdapter  {
    var context : Context
    var supplies : Supplies
    constructor(context : Context, supplies: Supplies){
        this.context = context
        this.supplies = supplies
    }
    override fun getCount(): Int {
        return supplies.supplies.size
    }
    override fun getItem(p0: Int): Any {
        return supplies.supplies[p0]
    }
    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View? {
        var view: View? = p1
        if (view == null) {
            view = View.inflate(context, R.layout.item_adapter, null)
        }
        var supplie = supplies.supplies[p0]
        var id = view?.findViewById<TextView>(R.id.txtId)
        id?.text = supplie.id.toString()
        var dato1 = view?.findViewById<TextView>(R.id.txtDato1)
        dato1?.text = "Referencia: " + supplie.reference
        var dato2 = view?.findViewById<TextView>(R.id.txtDato2)
        dato2?.text = "Nombre: " + supplie.name
        var dato3 = view?.findViewById<TextView>(R.id.txtDato3)
        val precio = BigDecimal(supplie.price).toPlainString()
        dato3?.text = "Precio: " + precio
        var dato4 = view?.findViewById<TextView>(R.id.txtDato4)
        var userName = Globals.getDatabase(context)?.userDao()?.getUserNameById(supplie.idUser)
        dato4?.text = "Usuario: " + userName
        return view
    }
}