package com.example.proyecto2.models
import android.content.Context
import androidx.room.Room
import com.example.proyecto2.models.database.ProjectDataBase
import com.example.proyecto2.models.database.entities.UserEntity
import com.example.proyecto2.models.database.entities.ClientEntity
import com.example.proyecto2.models.database.entities.SaleEntity
import com.example.proyecto2.models.database.entities.SaleDetailEntity
import com.example.proyecto2.models.database.entities.SupplieEntity
import com.example.proyecto2.models.database.entities.VehicleEntity

class Globals {
    companion object {
        var database: ProjectDataBase? = null
        var listaUsers: Users = Users(ArrayList<UserEntity>())
        var listaClients: Clients = Clients(ArrayList<ClientEntity>())
        var listaSales: Sales = Sales(ArrayList<SaleEntity>())
        var listaSaleDetails: SaleDetails = SaleDetails(ArrayList<SaleDetailEntity>())
        var listaSupplies: Supplies = Supplies(ArrayList<SupplieEntity>())
        var listaVehicles: Vehicles = Vehicles(ArrayList<VehicleEntity>())

        fun addSharePreference(context: Context, user: UserEntity) {
            var preferences = context.getSharedPreferences("user", Context.MODE_PRIVATE)
            var editor = preferences.edit()
            editor.putString("name", user.name)
            editor.putString("roll", user.roll)
            editor.putInt("id", user.id)
            editor.commit()
        }

        fun getSharePreferenceName(context: Context): String {
            var preferences = context.getSharedPreferences("user", Context.MODE_PRIVATE)
            var name = preferences.getString("name", "")
            return name.toString()
        }
        fun getSharePreferenceId(context: Context): Int {
            var preferences = context.getSharedPreferences("user", Context.MODE_PRIVATE)
            var id = preferences.getInt("id", 0)
            return id
        }
        fun getSharePreferenceRoll(context: Context): String {
            var preferences = context.getSharedPreferences("user", Context.MODE_PRIVATE)
            var roll = preferences.getString("roll", "")
            return roll.toString()
        }
        fun getDatabase(context: Context): ProjectDataBase? {
            return database
        }

        fun initDatabase(context: Context) {
            database =
                Room.databaseBuilder(context, ProjectDataBase::class.java, "project_database")
                    .allowMainThreadQueries().build()
        }
    }
}