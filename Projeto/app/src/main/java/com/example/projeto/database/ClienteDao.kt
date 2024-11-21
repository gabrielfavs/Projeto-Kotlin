package com.example.projeto.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ClienteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserirCliente(cliente: Cliente)

    @Update
    suspend fun atualizarCliente(cliente: Cliente)

    @Delete
    suspend fun deletarCliente(cliente: Cliente)

    @Query("SELECT * FROM clientes WHERE cpf = :cpf LIMIT 1")
    suspend fun buscarPorCpf(cpf: String): Cliente?

    @Query("SELECT * FROM clientes WHERE email = :email LIMIT 1")
    suspend fun buscarPorEmail(email: String): Cliente?

    @Query("SELECT * FROM clientes")
    fun listarClientes(): LiveData<List<Cliente>>
}
