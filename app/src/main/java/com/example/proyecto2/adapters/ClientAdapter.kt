package com.example.proyecto2.adapters
import android.content.Context
import android.widget.BaseAdapter
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.proyecto2.models.Clients
import com.example.proyecto2.models.database.entities.ClientEntity
import com.example.proyecto2.R
import com.example.proyecto2.models.Globals

class ClientAdapter : BaseAdapter {

    var context : Context
    var clients : Clients

    constructor(context : Context, clients: Clients){
        this.context = context
        this.clients = clients
    }
    override fun getCount(): Int {
        return clients.clients.size
    }

    override fun getItem(p0: Int): Any {
        return clients.clients[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View? {
        var view: View? = p1
        if (view == null) {
            view = View.inflate(context, R.layout.item_adapter, null)
        }
        var client = clients.clients[p0]
        var id = view?.findViewById<TextView>(R.id.txtId)
        id?.text = client.id.toString()
        var dato1 = view?.findViewById<TextView>(R.id.txtDato1)
        dato1?.text = "Nombre: " + client.name
        var dato2 = view?.findViewById<TextView>(R.id.txtDato2)
        dato2?.text = "Nit: " + client.nit
        var dato3 = view?.findViewById<TextView>(R.id.txtDato3)
        dato3?.text = "Telefono: " + client.phone
        var dato4 = view?.findViewById<TextView>(R.id.txtDato4)
        var userName = Globals.getDatabase(context)?.userDao()?.getUserNameById(client.idUser)
        dato4?.text = "Usuario: " + userName
        return view
    }
}