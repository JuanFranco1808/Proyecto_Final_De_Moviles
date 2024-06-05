package com.example.proyecto2.models.database.dao
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
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
}