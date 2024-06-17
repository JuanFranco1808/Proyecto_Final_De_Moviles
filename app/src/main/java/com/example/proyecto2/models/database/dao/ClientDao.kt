package com.example.proyecto2.models.database.dao
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.proyecto2.models.database.entities.ClientEntity
import com.example.proyecto2.models.database.entities.VehicleEntity

@Dao
interface ClientDao {
    @Insert
    fun insertClient(client: ClientEntity)
    @Delete
    fun deleteClient(client: ClientEntity)
    @Update
    fun updateClient(client: ClientEntity)
    @Query("SELECT * FROM client")
    fun getAllClients(): List<ClientEntity>
    @Query("SELECT name FROM client where id = :id")
    fun getClientNameById(id: Int): String

    @Query("SELECT * FROM client WHERE idUser = :id")
    fun getAllClientsByUserId(id: Int): List<ClientEntity>
}