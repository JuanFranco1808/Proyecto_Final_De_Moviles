package com.example.proyecto2.models.database.entities
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity (tableName = "supplie",
        foreignKeys = [
            ForeignKey(entity = UserEntity::class,
                parentColumns = ["id"],
                childColumns = ["idUser"])])
class SupplieEntity {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var reference : String = ""
    var name: String = ""
    var price: Double = 0.0
    var idUser: Int = 0

    fun getFullName(): String {
        return "$reference $name"
    }
}