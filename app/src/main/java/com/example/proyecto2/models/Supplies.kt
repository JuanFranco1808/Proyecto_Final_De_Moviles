package com.example.proyecto2.models
import com.example.proyecto2.models.database.entities.SupplieEntity
class Supplies {
    var supplies = ArrayList<SupplieEntity>()
    constructor(supplies: ArrayList<SupplieEntity>){
        this.supplies = supplies
    }
}