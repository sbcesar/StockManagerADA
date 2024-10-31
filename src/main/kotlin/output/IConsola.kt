package org.example.Output

interface IConsola {
    fun showMessage(message: String, lineBreak: Boolean = true)
    fun readMessage(): Any
}