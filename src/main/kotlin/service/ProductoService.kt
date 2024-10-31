package org.example.service

import org.example.Output.Consola
import org.example.model.Producto
import org.example.model.Proveedor
import org.example.repository.ProductoRepository
import java.time.LocalDate

class ProductoService(private val consola: Consola, private val productoRepository: ProductoRepository) {

    fun altaProducto(proveedor: Proveedor) {
        consola.showMessage("Escribe el nombre del producto: ")
        val nombreProducto = consola.readMessage()
        if (nombreProducto.isEmpty() || nombreProducto.length > 50) {
            consola.showMessage("El nombre es erroneo (menos de 50 caracteres)")
        }

        consola.showMessage("Escribe la categoría del producto: ")
        val categoria = consola.readMessage()
        if (categoria.isEmpty() || categoria.length > 50) {
            consola.showMessage("La categoria es erronea (menos de 50 caracteres)")
        }

        consola.showMessage("Escribe la descripción del producto: ")
        val descripcion = consola.readMessage()

        consola.showMessage("Escribe el precio sin iva (se le aplicará el 21% luego): ")
        val precioSinIva = consola.readMessage().toFloatOrNull() ?: return


        consola.showMessage("Escribe el stock del producto: ")
        val stock = consola.readMessage().toIntOrNull() ?: return


        val productoId = "${categoria.take(3)}${nombreProducto.take(3)}${proveedor.nombre.take(3)}"
        val precioConIva = precioSinIva * 1.21f
        val fechaAlta = LocalDate.now()

        val producto = Producto(productoId,categoria,nombreProducto,descripcion,precioSinIva,precioConIva,fechaAlta,stock,proveedor)

        productoRepository.altaProducto(producto)
    }

    fun bajaProducto(): String {
        consola.showMessage("Escribe el id del producto a dar de baja: ")
        val productoId = consola.readMessage()

        return productoRepository.bajaProducto(productoId)
    }

    fun modificarNombreProducto(): String {
        consola.showMessage("Escribe el id del producto cuyo nombre deseas modificar: ")
        val productoId = consola.readMessage()
        consola.showMessage("Escribe el nuevo nombre del producto: ")
        val nuevoNombre = consola.readMessage()

        return productoRepository.modificarNombreProducto(productoId,nuevoNombre)
    }

    fun modificarStockProducto(): String {
        consola.showMessage("Escribe el id del producto cuyo stock deseas modificar: ")
        val productoId = consola.readMessage()
        consola.showMessage("Escribe el nuevo stock del producto: ")
        val nuevoStock = consola.readMessage().toIntOrNull() ?: 0

        return productoRepository.modificarStockProducto(productoId,nuevoStock)
    }

    fun getProducto(): String {
        consola.showMessage("Escribe el id del producto que deseas ver: ")
        val productoId = consola.readMessage()

        return productoRepository.getProducto(productoId)
    }

    fun getProductosConStock(): List<Producto> {
        return productoRepository.getProductosConStock()
    }

    fun getProductosSinStock(): List<Producto> {
        return productoRepository.getProductosSinStock()
    }
}