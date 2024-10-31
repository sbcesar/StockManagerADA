package org.example.service

import org.example.Output.Consola
import org.example.repository.UsuarioRepository

class UsuarioService(private val consola: Consola, private val usuarioRepository: UsuarioRepository) {

    fun getUserInput(): String {
        consola.showMessage("Escribe el nombre del usuario (puede ser tu nombre, correo, mote...)")
        val userInput = consola.readMessage()
        return userInput
    }

    fun getPasswordInput(): String {
        consola.showMessage("Escribe la contraseña: ")
        val passInput = consola.readMessage()
        return passInput
    }

    fun login(): String {
        val nombreUsuario = getUserInput()
        val password = getPasswordInput()
        return usuarioRepository.login(nombreUsuario,password)
    }
}