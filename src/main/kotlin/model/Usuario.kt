package org.example.model

import jakarta.persistence.*


@Entity
@Table(name = "usuario")
data class Usuario(

    @Id
    private var nombreUsuario: String,

    @Column(name = "password", nullable = false, length = 20)
    private var password: String

) {

    fun getNombreUsuario(): String {
        return nombreUsuario
    }

    fun setNombreUsuario(newNombreUsuario: String) {
        this.nombreUsuario = newNombreUsuario
    }

    fun getPassword(): String {
        return password
    }

    fun setPassword(newPassword: String) {
        this.password = newPassword
    }
}