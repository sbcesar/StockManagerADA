package org.example.Output

class Consola: IConsola {

    override fun showMessage(message: String, lineBreak: Boolean) {
        if (lineBreak) {
            println(message)
        } else {
            print(message)
        }
    }

    override fun readMessage(): String {
        return readln()
    }

}