package com.example.projeto.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PedidoViewModel(private val repository: PedidoRepository) : ViewModel() {

    fun listarPedidosPorCliente(clienteId: Int): LiveData<List<Pedido>> =
        repository.listarPedidosPorCliente(clienteId)

    fun inserirPedido(pedido: Pedido) {
        viewModelScope.launch {
            repository.inserirPedido(pedido)
        }
    }

    fun atualizarPedido(pedido: Pedido) {
        viewModelScope.launch {
            repository.atualizarPedido(pedido)
        }
    }

    fun deletarPedido(pedido: Pedido) {
        viewModelScope.launch {
            repository.deletarPedido(pedido)
        }
    }

    fun buscarPorCodigo(codigo: String, callback: (Pedido?) -> Unit) {
        viewModelScope.launch {
            callback(repository.buscarPorCodigo(codigo))
        }
    }

    fun buscarPorNome(nome: String): LiveData<List<Pedido>> = repository.buscarPorNome(nome)
}
