package org.example.repository

import jakarta.persistence.EntityManager
import org.example.model.Producto
import org.example.utils.HibernateUtils

class ProductoRepository {

    fun altaProducto(producto: Producto): String {
        val em: EntityManager = HibernateUtils.createEntityManager()
        try {
            em.transaction.begin()
            em.persist(producto)
            em.transaction.commit()
            return "El producto con id ${producto.id} se ha dado de alta."
        } catch (e: Exception) {
            em.transaction.rollback()
            return "*** ERROR *** No se pudo dar de alta al producto con id ${producto.id}. -> ${e.message}"
        } finally {
            em.close()
        }
    }

    fun bajaProducto(productoId: String): String {
        val em: EntityManager = HibernateUtils.createEntityManager()
        try {
            em.transaction.begin()
            em.remove(em.find(Producto::class.java, productoId))
            em.transaction.commit()
            return "El producto con id $productoId ha sido dado de baja."
        } catch (e: Exception) {
            em.transaction.rollback()
            return "*** ERROR *** No se pudo dar de baja al producto con id $productoId. -> ${e.message}"
        } finally {
            em.close()
        }
    }

    fun modificarNombreProducto(productoId: String, nuevoNombre: String): String {
        val em: EntityManager = HibernateUtils.createEntityManager()
        try {
            em.transaction.begin()
            val producto = em.find(Producto::class.java, productoId)
            if (producto != null) {
                producto.nombre = nuevoNombre
                em.merge(producto)
                em.transaction.commit()
                return "El producto con id $productoId ha sido cambiado de nombre a $nuevoNombre."
            } else {
                em.transaction.rollback()
                return "No se encontro el producto con el nombre $nuevoNombre"
            }
        } catch (e: Exception) {
            em.transaction.rollback()
            return "*** ERROR *** No se pudo cambiar el nombre del producto. -> ${e.message}"
        } finally {
            em.close()
        }
    }

    fun modificarStockProducto(productoId: String, nuevoStock: Int): String {
        val em: EntityManager = HibernateUtils.createEntityManager()
        try {
            em.transaction.begin()
            val producto = em.find(Producto::class.java,productoId)
            if (producto != null) {
                producto.stock = nuevoStock
                em.transaction.commit()
                return "El stock del producto con id $productoId ha sido cambiado a $nuevoStock."
            } else {
                em.transaction.rollback()
                return "No se encontro el producto con el id $productoId"
            }
        } catch (e: Exception) {
            em.transaction.rollback()
            return "*** ERROR *** No se pudo cambiar el stock del producto con id $productoId. -> ${e.message}"
        } finally {
            em.close()
        }
    }

    fun getProducto(productoId: String): String {
        val em: EntityManager = HibernateUtils.createEntityManager()
        return try {
            val producto = em.find(Producto::class.java, productoId)
            producto?.toString() ?: "No se encontro el producto con el id $productoId"
        } catch (e: Exception) {
            "*** ERROR *** No se pudo cambiar el nombre del producto. -> ${e.message}"
        } finally {
            em.close()
        }
    }

    fun getProductosConStock(): List<Producto> {
        val em: EntityManager = HibernateUtils.createEntityManager()
        try {
            val query = em.createQuery("SELECT from Producto WHERE Producto.stock > 0", Producto::class.java)
            return query.resultList
        } catch (e: Exception) {
            return emptyList()
        } finally {
            em.close()
        }
    }

    fun getProductosSinStock(): List<Producto> {
        val em: EntityManager = HibernateUtils.createEntityManager()
        try {
            val query = em.createQuery("SELECT from Producto WHERE Producto.stock = 0", Producto::class.java)
            return query.resultList
        } catch (e: Exception) {
            return emptyList()
        } finally {
            em.close()
        }
    }
}