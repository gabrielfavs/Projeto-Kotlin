package com.example.projeto.repository

class ClienteRepository(private val clienteDao: ClienteDao) {

    fun listarClientes(): LiveData<List<Cliente>> = clienteDao.listarClientes()

    suspend fun inserirCliente(cliente: Cliente) = clienteDao.inserirCliente(cliente)

    suspend fun atualizarCliente(cliente: Cliente) = clienteDao.atualizarCliente(cliente)

    suspend fun deletarCliente(cliente: Cliente) = clienteDao.deletarCliente(cliente)

    suspend fun buscarPorCpf(cpf: String): Cliente? = clienteDao.buscarPorCpf(cpf)

    suspend fun buscarPorEmail(email: String): Cliente? = clienteDao.buscarPorEmail(email)
}
