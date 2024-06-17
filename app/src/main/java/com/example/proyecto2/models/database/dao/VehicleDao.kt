package com.example.proyecto2.models.database.dao
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.proyecto2.models.database.entities.SupplieEntity
import com.example.proyecto2.models.database.entities.VehicleEntity

@Dao
interface VehicleDao {
    @Insert
    fun insertVehicle(vehicle: VehicleEntity)
    @Delete
    fun deleteVehicle(vehicle: VehicleEntity)
    @Update
    fun updateVehicle(vehicle: VehicleEntity)
    @Query("SELECT * FROM vehicle")
    fun getAllVehicles(): List<VehicleEntity>
    @Query("SELECT brand || ' ' || model FROM vehicle WHERE id = :id")
    fun getVehicleNameById(id: Int): String
    @Query("SELECT * FROM vehicle WHERE idUser = :id")
    fun getAllVehiclesByUserId(id: Int): List<VehicleEntity>
}