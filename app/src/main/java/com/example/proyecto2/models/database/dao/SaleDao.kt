package com.example.proyecto2.models.database.dao
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.proyecto2.models.database.entities.SaleEntity

@Dao
interface SaleDao {
    @Insert
    fun insertSale(sale: SaleEntity)
    @Delete
    fun deleteSale(sale: SaleEntity)
    @Update
    fun updateSale(sale: SaleEntity)
    @Query("SELECT * FROM sale")
    fun getAllSales(): List<SaleEntity>
}