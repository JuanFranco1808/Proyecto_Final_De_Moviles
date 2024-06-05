package com.example.proyecto2.models.database.dao
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.proyecto2.models.database.entities.SaleDetailEntity

@Dao
interface SaleDetailDao {
    @Insert
    fun insertSaleDetail(saleDetail: SaleDetailEntity)
    @Delete
    fun deleteSaleDetail(saleDetail: SaleDetailEntity)
    @Update
    fun updateSaleDetail(saleDetail: SaleDetailEntity)
    @Query("SELECT * FROM saleDetail")
    fun getAllSaleDetails(): List<SaleDetailEntity>
    @Query("SELECT * FROM saleDetail WHERE id = :id")
    fun getSaleDetailById(id: Int): SaleDetailEntity
}