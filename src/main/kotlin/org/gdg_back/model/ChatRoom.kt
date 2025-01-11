package org.gdg_back.model

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "chat_rooms")
class ChatRoom(
    @Id
    @Column(name = "room_id", updatable = false, nullable = false)
    val id: UUID = UUID.randomUUID(),

    val title: String,

    var status: String = "ACTIVE",

    @Column(columnDefinition = "TEXT")
    var summary: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User,

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "completed_at")
    var completedAt: LocalDateTime? = null,

    @OneToMany(mappedBy = "chatRoom", cascade = [CascadeType.ALL], orphanRemoval = true)
    val messages: MutableSet<ChatMessage> = mutableSetOf(),

    @ManyToMany
    @JoinTable(
        name = "chat_room_persons",
        joinColumns = [JoinColumn(name = "room_id")],
        inverseJoinColumns = [JoinColumn(name = "person_id")]
    )
    val persons: MutableSet<BasicInfo> = mutableSetOf()
)