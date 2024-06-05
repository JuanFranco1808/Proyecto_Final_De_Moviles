package com.example.proyecto2.models.database.entities
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity (tableName = "user")
class UserEntity {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var cedula: String =""
    var name: String = ""
    var password: String = ""
    var roll: String = ""
    fun getDataPreference(): String {
        //retornar json
        return "{\"id\":\"${id.toString()}\",\"name\":\"$name\",\"roll\":\"$roll\"}"
    }
}