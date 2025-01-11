package org.gdg_back.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "professional_info")
class ProfessionalInfo(
    @Id @GeneratedValue(generator = "UUID")
    @Column(name = "professional_id", updatable = false, nullable = false)
    val id: UUID = UUID.randomUUID(),

    @Column(name = "primary_occupation")
    val primaryOccupation: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    val person: BasicInfo
){}