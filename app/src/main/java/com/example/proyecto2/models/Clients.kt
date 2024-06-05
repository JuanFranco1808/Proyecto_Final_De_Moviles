package com.example.proyecto2.models
import com.example.proyecto2.models.database.entities.ClientEntity


class Clients {
    var clients = ArrayList<ClientEntity>()
    constructor(clients: ArrayList<ClientEntity>){
        this.clients = clients
    }
}