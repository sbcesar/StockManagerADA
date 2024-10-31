package org.example

import org.example.Output.Consola
import org.example.Output.Menu
import org.example.repository.ProductoRepository
import org.example.repository.ProveedorRepository
import org.example.repository.UsuarioRepository
import org.example.service.ProductoService
import org.example.service.ProveedorService
import org.example.service.UsuarioService

fun main() {
    val consola = Consola()

    val proveedorRepository = ProveedorRepository()
    val proveedorService = ProveedorService(consola, proveedorRepository)

    val productoRepository = ProductoRepository()
    val productoService = ProductoService(consola, productoRepository)

    val usuarioRepository = UsuarioRepository()
    val usuarioService = UsuarioService(consola,usuarioRepository)

    val menu = Menu(consola,proveedorService,productoService, usuarioService)

    menu.mostrarMenu()

}