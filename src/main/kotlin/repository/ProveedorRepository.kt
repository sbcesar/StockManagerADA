package org.example.repository

import org.example.model.Producto
import org.example.model.Proveedor
import org.example.utils.HibernateUtils

class ProveedorRepository {

    fun getProveedorProducto(productoId: String): Proveedor? {
        val em = HibernateUtils.createEntityManager()
        return try {
            em.find(Producto::class.java, productoId)?.proveedor
        } catch (e: Exception) {
            null
        } finally {
            em.close()
        }
    }

    fun getTodosProveedores(): List<Proveedor> {
        val em = HibernateUtils.createEntityManager()
        try {
            val query = em.createQuery("SELECT * FROM Proveedor", Proveedor::class.java)
            return query.resultList
        } catch (e: Exception) {
            return emptyList()
        } finally {
            em.close()
        }
    }
}