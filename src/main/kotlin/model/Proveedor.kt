package org.example.model

import jakarta.persistence.*

@Entity
@Table(name = "proveedor")
class Proveedor(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    @Column(name = "nombre_proveedor")
    val nombre: String,

    @Column(name = "direccion")
    val direccion: String,

    @OneToMany(mappedBy = "proveedor", cascade = [CascadeType.ALL])
    val productos: List<Producto>?
) {
}