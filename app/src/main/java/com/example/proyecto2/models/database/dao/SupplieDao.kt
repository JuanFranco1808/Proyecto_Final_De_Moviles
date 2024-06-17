package com.example.proyecto2.models.database.dao
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.proyecto2.models.database.entities.SaleEntity
import com.example.proyecto2.models.database.entities.SupplieEntity

@Dao
interface SupplieDao {
    @Insert
    fun insertSupplie(supplie: SupplieEntity)
    @Delete
    fun deleteSupplie(supplie: SupplieEntity)
    @Update
    fun updateSupplie(supplie: SupplieEntity)
    @Query("SELECT * FROM supplie")
    fun getAllSupplies(): List<SupplieEntity>
    @Query("SELECT name  || ' ' ||  reference   FROM supplie where id = :id")
    fun getSupplieNameById(id: Int): String

    @Query("SELECT * FROM supplie WHERE idUser = :id")
    fun getAllSuppliesByUserId(id: Int): List<SupplieEntity>
}