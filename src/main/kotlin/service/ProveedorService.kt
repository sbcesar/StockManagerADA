package org.example.service

import org.example.Output.Consola
import org.example.model.Proveedor
import org.example.repository.ProveedorRepository

class ProveedorService(private val consola: Consola, private val proveedorRepository: ProveedorRepository) {

    fun getProveedor(): Proveedor? {
        consola.showMessage("Escribe el id del producto para ver el proveedor de este: ")
        val productoId = consola.readMessage()

        val proveedor = proveedorRepository.getProveedorProducto(productoId)

        return proveedor
    }

    fun getTodosProveedores(): List<Proveedor> {
        return proveedorRepository.getTodosProveedores()
    }
}