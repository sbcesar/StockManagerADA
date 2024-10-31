package org.example.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "producto")
data class Producto(

    @Id
    var id: String? = null,

    @Column(name = "categoria")
    val categoria: String,

    @Column(name = "nombre_producto")
    var nombre: String,

    @Column(name = "descripcion")
    val descripcion: String,

    @Column(name = "precio_sin_iva")
    val precioSinIva: Float,

    @Column(name = "precio_con_iva")
    val precioConIva: Float = (precioSinIva * 1.21).toFloat(),

    @Column(name = "fecha_alta")
    @Temporal(TemporalType.DATE)
    val fechaAlta: LocalDate = LocalDate.now(),

    @Column(name = "stock")
    var stock: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proveedor_id")
    val proveedor: Proveedor
) {

    init {
        if (id == null) {
            id = createId()
        }
    }

    private fun createId(): String {
        val categoryChars = categoria.take(3).uppercase()
        val nombreChars = nombre.take(3).uppercase()
        val proveedorChars = proveedor.nombre.take(3).uppercase()

        return categoryChars + nombreChars + proveedorChars
    }

    override fun toString(): String {
        return "Id: $id\nCategoria: $categoria\nNombre: $nombre\nDescripcion: $descripcion\nPrecio sin iva: $precioSinIva €\nPrecio con iva: $precioConIva €\nFecha de alta: $fechaAlta\nStock: $stock\nProveedor: $proveedor\n"
    }

}