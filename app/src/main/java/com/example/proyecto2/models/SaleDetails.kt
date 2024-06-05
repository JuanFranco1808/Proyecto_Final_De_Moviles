package com.example.proyecto2.models
import com.example.proyecto2.models.database.entities.SaleDetailEntity

class SaleDetails {
    var saleDetails = ArrayList<SaleDetailEntity>()
    constructor(saleDetails: ArrayList<SaleDetailEntity>){
        this.saleDetails = saleDetails
    }
}