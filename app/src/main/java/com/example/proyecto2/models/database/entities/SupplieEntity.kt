package com.example.proyecto2.models.database.entities
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "supplie")
class SupplieEntity {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var reference : String = ""
    var name: String = ""
    var price: Double = 0.0

    fun getFullName(): String {
        return "$reference $name"
    }
}