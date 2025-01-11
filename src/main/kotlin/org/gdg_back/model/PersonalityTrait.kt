package org.gdg_back.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "personality_traits")
class PersonalityTrait(
    @Id
    @Column(name = "trait_id", updatable = false, nullable = false)
    val id: UUID = UUID.randomUUID(),

    @Column(name = "trait_name")
    val traitName: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    val person: BasicInfo
){}