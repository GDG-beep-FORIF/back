package org.gdg_back.model

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "users")
class User(
    @Id
    @Column(name = "user_id", nullable = false, updatable = false)
    val id: UUID = UUID.randomUUID(), // 직접 생성

    @Column(unique = true, nullable = false)
    var email: String,

    @Column(name = "password_hash", nullable = false)
    var passwordHash: String,

    @Column(nullable = false)
    var username: String,

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    val chatRooms: MutableSet<ChatRoom> = mutableSetOf(),

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    val messages: MutableSet<ChatMessage> = mutableSetOf()
) {
}