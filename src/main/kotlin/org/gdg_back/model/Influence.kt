package org.gdg_back.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "influences")
class Influence(
    @Id @GeneratedValue(generator = "UUID")
    @Column(name = "influence_id", updatable = false, nullable = false)
    val id: UUID = UUID.randomUUID(),

    @Column(name = "influence_name")
    val influenceName: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    val person: BasicInfo
){}