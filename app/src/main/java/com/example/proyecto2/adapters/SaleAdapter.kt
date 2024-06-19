package com.example.proyecto2.adapters
import android.content.Context
import android.content.Intent
import android.widget.BaseAdapter
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.proyecto2.models.Sales
import com.example.proyecto2.models.database.entities.SaleEntity
import com.example.proyecto2.R
import com.example.proyecto2.models.Globals
import com.example.proyecto2.views.ViewList
import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class SaleAdapter : BaseAdapter{
    var context : Context
    var sales : Sales
    constructor(context : Context, sales: Sales){
        this.context = context
        this.sales = sales
    }
    override fun getCount(): Int {
        return sales.sales.size
    }
    override fun getItem(p0: Int): Any {
        return sales.sales[p0]
    }
    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View? {
        var view: View? = p1
        if (view == null) {
            view = View.inflate(context, R.layout.sale_list_adapter, null)
        }
        var sale = sales.sales[p0]

        var txtSaleIdClient = view?.findViewById<TextView>(R.id.txtSaleIdClient)
        var clientName = Globals.getDatabase(context)?.clientDao()?.getClientNameById(sale.idClient)
        txtSaleIdClient?.text = "Cliente: " + clientName

        var txtSaleTotal = view?.findViewById<TextView>(R.id.txtSaleTotal)
        val precio = BigDecimal(sale.total).toPlainString()
        txtSaleTotal?.text = "Total: " + precio

        var txtSaleIdUser = view?.findViewById<TextView>(R.id.txtSaleIdUser)
        var userName = Globals.getDatabase(context)?.userDao()?.getUserNameById(sale.idUser)
        //convertir a formato dia mes año la fecha y en texto
        val timestamp = sale.date.toLong()
        // Crear un objeto Date a partir del timestamp
        val date = Date(timestamp)
        // Formatear la fecha
        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val formattedDate = sdf.format(date)
        txtSaleIdUser?.text = "Fecha:" + formattedDate.toString()+ "\nUsuario:" +userName

        var button = view?.findViewById<TextView>(R.id.btnSaleDetails)
        button?.setOnClickListener {
            val intent = Intent(context, ViewList::class.java)
            intent.putExtra("tipo", "saleDetails")
            intent.putExtra("id", sale.id)
            context.startActivity(intent)
        }
        return view
    }
}