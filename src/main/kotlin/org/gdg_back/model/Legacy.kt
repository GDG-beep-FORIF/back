package org.gdg_back.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "legacy")
class Legacy(
    @Id
    @Column(name = "legacy_id", updatable = false, nullable = false)
    val id: UUID = UUID.randomUUID(),

    @Column(columnDefinition = "text")
    val impact: String? = null,

    @Column(name = "modern_significance", columnDefinition = "text")
    val modernSignificance: String? = null,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    val person: BasicInfo
){}