package org.gdg_back.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "key_events")
class KeyEvent(
    @Id @GeneratedValue(generator = "UUID")
    @Column(name = "event_id", updatable = false, nullable = false)
    val id: UUID = UUID.randomUUID(),

    @Column(name = "event_description", columnDefinition = "text")
    val eventDescription: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    val person: BasicInfo
){}