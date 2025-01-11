package org.gdg_back.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "historical_context")
class HistoricalContext(
    @Id @GeneratedValue(generator = "UUID")
    @Column(name = "context_id", updatable = false, nullable = false)
    val id: UUID = UUID.randomUUID(),

    @Column(name = "period_background", columnDefinition = "text")
    val periodBackground: String? = null,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    val person: BasicInfo
){}