package com.example.proyecto2.models.database.dao
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.proyecto2.models.database.entities.UserEntity

@Dao
interface UserDao {
    @Insert
    fun insertUser(user: UserEntity)
    @Delete
    fun deleteUser(user: UserEntity)
    @Update
    fun updateUser(user: UserEntity)
    @Query("SELECT * FROM user")
    fun getAllUsers(): List<UserEntity>
    @Query("SELECT * FROM user where cedula = :cedula and password = :password")
    fun getUserByCedulaAndPassword(cedula: String, password: String): UserEntity

}