package com.example.proyecto2.models.database.entities
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey

@Entity (tableName = "sale",
        foreignKeys = [ForeignKey(entity = UserEntity::class,
        parentColumns = ["id"],
        childColumns = ["idUser"]),
        ForeignKey(entity = ClientEntity::class,
        parentColumns = ["id"],
        childColumns = ["idClient"])])
class SaleEntity {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var idUser: Int = 0
    var idClient: Int = 0
    var date: String = ""
    var total: Double = 0.0
    fun getFullName(): String {
        return "$date $total"
    }

}