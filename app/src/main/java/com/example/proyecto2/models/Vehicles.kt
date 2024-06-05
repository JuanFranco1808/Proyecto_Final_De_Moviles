package com.example.proyecto2.models
import com.example.proyecto2.models.database.entities.VehicleEntity
class Vehicles {
    var vehicles = ArrayList<VehicleEntity>()
    constructor(vehicles: ArrayList<VehicleEntity>){
        this.vehicles = vehicles
    }
}