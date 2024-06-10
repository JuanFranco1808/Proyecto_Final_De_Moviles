package com.example.proyecto2.models.database.entities
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity (tableName = "client",
        foreignKeys = [
            ForeignKey(entity = UserEntity::class,
            parentColumns = ["id"],
            childColumns = ["idUser"])])
class ClientEntity {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var nit : String = ""
    var name: String = ""
    var address: String = ""
    var phone: String = ""
    var idUser: Int = 0
}