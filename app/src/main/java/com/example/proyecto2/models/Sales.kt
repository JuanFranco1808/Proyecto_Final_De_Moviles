package com.example.proyecto2.models
import com.example.proyecto2.models.database.entities.SaleEntity
class Sales {
    var sales = ArrayList<SaleEntity>()
    constructor(sales: ArrayList<SaleEntity>){
        this.sales = sales
    }
}