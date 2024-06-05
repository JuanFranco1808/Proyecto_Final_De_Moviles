package com.example.proyecto2.models.database.dao
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.proyecto2.models.database.entities.ClientEntity
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
}