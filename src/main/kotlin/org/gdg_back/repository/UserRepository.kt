package org.gdg_back.repository

import org.gdg_back.model.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository : JpaRepository<User, UUID>{
    fun findByEmail(email: String): User?
    fun existsByEmail(email: String): Boolean
}
