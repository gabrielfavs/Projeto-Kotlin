package com.example.projeto.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PedidoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserirPedido(pedido: Pedido)

    @Update
    suspend fun atualizarPedido(pedido: Pedido)

    @Delete
    suspend fun deletarPedido(pedido: Pedido)

    @Query("SELECT * FROM pedidos WHERE codigoProduto = :codigo LIMIT 1")
    suspend fun buscarPorCodigo(codigo: String): Pedido?

    @Query("SELECT * FROM pedidos WHERE nomeProduto LIKE '%' || :nome || '%'")
    fun buscarPorNome(nome: String): LiveData<List<Pedido>>

    @Query("SELECT * FROM pedidos WHERE clienteId = :clienteId")
    fun listarPedidosPorCliente(clienteId: Int): LiveData<List<Pedido>>
}
