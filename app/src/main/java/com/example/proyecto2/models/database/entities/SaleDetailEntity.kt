package com.example.proyecto2.models.database.entities
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity (tableName = "saleDetail",
    foreignKeys = [ForeignKey(entity = SaleEntity::class,
        parentColumns = ["id"],
        childColumns = ["idSale"])])
class SaleDetailEntity {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var idSale: Int = 0
    var itemType : String = ""
    var itemId: Int = 0
    var quantity: Int = 0
    var price: Double = 0.0
}