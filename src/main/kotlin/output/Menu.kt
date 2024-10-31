package org.example.Output

import org.example.service.ProductoService
import org.example.service.ProveedorService
import org.example.service.UsuarioService

class Menu(private val consola: Consola, private val proveedorService: ProveedorService, private val productoService: ProductoService, private val usuarioService: UsuarioService) {

    fun mostrarMenu() {
        var opcion: Int

        do {
            consola.showMessage("\nStock Manager App")
            consola.showMessage("-1. Login")
            consola.showMessage("1. Alta del producto")
            consola.showMessage("2. Baja del producto")
            consola.showMessage("3. Modificar el nombre dek producto")
            consola.showMessage("4. Modificar el stock del producto")
            consola.showMessage("5. Obtener producto por Id")
            consola.showMessage("6. Obtener los productos con stock")
            consola.showMessage("7. Obtener los productos sin stock")
            consola.showMessage("8. Obtener el proveedor de un producto")
            consola.showMessage("9. Obtener todos los proveedores")
            consola.showMessage("0. Salir")
            consola.showMessage("Seleccione una opción: ")

            opcion = consola.readMessage().toInt()

            when (opcion) {
                -1 -> {
                    usuarioService.login()
                }
                1 -> {
                    val proveedor = proveedorService.getProveedor()
                    if (proveedor != null) {
                        productoService.altaProducto(proveedor)
                    } else {
                        consola.showMessage("No se encontró el proveedor")
                    }
                }
                2 -> consola.showMessage(productoService.bajaProducto())
                3 -> consola.showMessage(productoService.modificarNombreProducto())
                4 -> consola.showMessage(productoService.modificarStockProducto())
                5 -> consola.showMessage(productoService.getProducto())
                6 -> {
                    val productos = productoService.getProductosConStock()
                    productos.forEach { consola.showMessage(it.toString()) }
                }
                7 -> {
                    val productos = productoService.getProductosSinStock()
                    productos.forEach { consola.showMessage(it.toString()) }
                }
                8 -> {
                    val proveedor = proveedorService.getProveedor()
                    if (proveedor != null) {
                        consola.showMessage(proveedor.toString())
                    } else {
                        consola.showMessage("No se encontró el proveedor del producto")
                    }
                }
                9 -> {
                    val proveedores = proveedorService.getTodosProveedores()
                    proveedores.forEach { consola.showMessage(it.toString()) }
                }
                0 -> consola.showMessage("Saliendo...")
                else -> consola.showMessage("Opción no válida, por favor intente de nuevo.")
            }

        } while (opcion != 0)

    }
}