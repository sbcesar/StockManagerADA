package org.example.utils

import jakarta.persistence.EntityManager
import jakarta.persistence.Persistence

object HibernateUtils {
    private val emf = Persistence.createEntityManagerFactory("UserPersistenceUnit")

    fun createEntityManager(): EntityManager {
        return emf.createEntityManager()
    }

    fun closeEntityManager() {
        if (emf.isOpen) {
            emf.close()
        }
    }
}