package com.example.proyecto2.models.database.entities
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "client")
class ClientEntity {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var nit : String = ""
    var name: String = ""
    var address: String = ""
    var phone: String = ""
}