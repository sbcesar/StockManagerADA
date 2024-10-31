package org.example.repository

import org.example.model.Usuario
import org.example.utils.HibernateUtils

class UsuarioRepository {

    fun login(userInput: String, passInput: String): String {
        val usuario = getUsuario(userInput)

        return if (usuario != null && usuario.getPassword() == passInput) {
            "Se ha iniciado sesion: ${usuario.getNombreUsuario()}"
        } else {
            "Hubo un fallo en el inicio de sesion"
        }
    }

    fun getUsuario(nombreusuario: String): Usuario? {
        val em = HibernateUtils.createEntityManager()
        try {
            val query = em.createQuery("SELECT u FROM usuario WHERE u.nombreUsuario = :nombreUsuario",Usuario::class.java)
            query.setParameter("nombreUsuario", nombreusuario)
            return query.resultList.firstOrNull()
        } catch (e: Exception) {
            return null
        } finally {
            em.close()
        }
    }

}