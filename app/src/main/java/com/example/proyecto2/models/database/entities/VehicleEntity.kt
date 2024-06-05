package com.example.proyecto2.models.database.entities
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "vehicle")
class VehicleEntity {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var brand: String = ""
    var model: String = ""
    var price: Double = 0.0

    fun getFullName(): String {
        return "$brand $model"
    }

}