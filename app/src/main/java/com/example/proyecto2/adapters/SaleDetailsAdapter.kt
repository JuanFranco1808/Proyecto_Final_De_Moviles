package com.example.proyecto2.adapters
import android.content.Context
import android.widget.BaseAdapter
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.proyecto2.models.SaleDetails
import com.example.proyecto2.models.database.entities.SaleDetailEntity
import com.example.proyecto2.R
import com.example.proyecto2.models.Globals
import java.math.BigDecimal
class SaleDetailsAdapter : BaseAdapter {
    var context : Context
    var saleDetails : SaleDetails
    constructor(context : Context, saleDetails: SaleDetails){
        this.context = context
        this.saleDetails = saleDetails
    }
    override fun getCount(): Int {
        return saleDetails.saleDetails.size
    }
    override fun getItem(p0: Int): Any {
        return saleDetails.saleDetails[p0]
    }
    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View? {
        var view: View? = p1
        if (view == null) {
            view = View.inflate(context, R.layout.item_adapter, null)
        }
        var saleDetail = saleDetails.saleDetails[p0]
        var id = view?.findViewById<TextView>(R.id.txtId)
        id?.text = saleDetail.id.toString()
        var dato1 = view?.findViewById<TextView>(R.id.txtDato1)
        dato1?.text = "Tipo: " + saleDetail.itemType
        var dato3 = view?.findViewById<TextView>(R.id.txtDato3)
        var productName = ""
        if (saleDetail.itemType == "Vehiculo"){
            productName = Globals.getDatabase(context)?.vehicleDao()?.getVehicleNameById(saleDetail.itemId).toString()
        }else{
            productName = Globals.getDatabase(context)?.supplieDao()?.getSupplieNameById(saleDetail.itemId).toString()
        }
        dato3?.text = "Producto: " + productName


        var dato4 = view?.findViewById<TextView>(R.id.txtDato4)
        val precio = BigDecimal(saleDetail.price).toPlainString()
        dato4?.text = "Precio: " + precio

        var dato2 = view?.findViewById<TextView>(R.id.txtDato2)
        val cantidad = saleDetail.quantity.toString()
        dato2?.text = "Cantidad: " + cantidad

        return view
    }
}