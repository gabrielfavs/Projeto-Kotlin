package com.example.projeto.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Cliente::class, Pedido::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun clienteDao(): ClienteDao
    abstract fun pedidoDao(): PedidoDao
}
