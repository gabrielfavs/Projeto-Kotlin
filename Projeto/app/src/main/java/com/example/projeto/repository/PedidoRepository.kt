package com.example.projeto.repository

class PedidoRepository(private val pedidoDao: PedidoDao) {

    fun listarPedidosPorCliente(clienteId: Int): LiveData<List<Pedido>> =
        pedidoDao.listarPedidosPorCliente(clienteId)

    suspend fun inserirPedido(pedido: Pedido) = pedidoDao.inserirPedido(pedido)

    suspend fun atualizarPedido(pedido: Pedido) = pedidoDao.atualizarPedido(pedido)

    suspend fun deletarPedido(pedido: Pedido) = pedidoDao.deletarPedido(pedido)

    suspend fun buscarPorCodigo(codigo: String): Pedido? = pedidoDao.buscarPorCodigo(codigo)

    fun buscarPorNome(nome: String): LiveData<List<Pedido>> = pedidoDao.buscarPorNome(nome)
}
