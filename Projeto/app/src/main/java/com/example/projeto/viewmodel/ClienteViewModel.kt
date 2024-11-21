package com.example.projeto.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ClienteViewModel(private val repository: ClienteRepository) : ViewModel() {

    val clientes: LiveData<List<Cliente>> = repository.listarClientes()

    fun inserirCliente(cliente: Cliente) {
        viewModelScope.launch {
            repository.inserirCliente(cliente)
        }
    }

    fun atualizarCliente(cliente: Cliente) {
        viewModelScope.launch {
            repository.atualizarCliente(cliente)
        }
    }

    fun deletarCliente(cliente: Cliente) {
        viewModelScope.launch {
            repository.deletarCliente(cliente)
        }
    }

    fun buscarPorCpf(cpf: String, callback: (Cliente?) -> Unit) {
        viewModelScope.launch {
            callback(repository.buscarPorCpf(cpf))
        }
    }

    fun buscarPorEmail(email: String, callback: (Cliente?) -> Unit) {
        viewModelScope.launch {
            callback(repository.buscarPorEmail(email))
        }
    }
}
