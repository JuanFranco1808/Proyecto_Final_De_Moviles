package com.example.proyecto2.models.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.proyecto2.models.database.dao.UserDao
import com.example.proyecto2.models.database.entities.UserEntity
import com.example.proyecto2.models.database.dao.ClientDao
import com.example.proyecto2.models.database.entities.ClientEntity
import com.example.proyecto2.models.database.dao.SaleDetailDao
import com.example.proyecto2.models.database.entities.SaleDetailEntity
import com.example.proyecto2.models.database.dao.SaleDao
import com.example.proyecto2.models.database.entities.SaleEntity
import com.example.proyecto2.models.database.dao.SupplieDao
import com.example.proyecto2.models.database.entities.SupplieEntity
import com.example.proyecto2.models.database.dao.VehicleDao
import com.example.proyecto2.models.database.entities.VehicleEntity


@Database(entities = [UserEntity::class, ClientEntity::class, SaleDetailEntity::class, SaleEntity::class, SupplieEntity::class, VehicleEntity::class], version = 1)
abstract class ProjectDataBase: RoomDatabase(){
    abstract fun userDao(): UserDao
    abstract fun clientDao(): ClientDao
    abstract fun saleDetailDao(): SaleDetailDao
    abstract fun saleDao(): SaleDao
    abstract fun supplieDao(): SupplieDao
    abstract fun vehicleDao(): VehicleDao

}