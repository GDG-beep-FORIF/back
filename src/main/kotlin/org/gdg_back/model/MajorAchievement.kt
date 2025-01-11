package org.gdg_back.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "major_achievements")
class MajorAchievement(
    @Id
    @Column(name = "achievement_id", updatable = false, nullable = false)
    val id: UUID = UUID.randomUUID(),

    @Column(name = "achievement_name", columnDefinition = "text")
    val achievementName: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    val person: BasicInfo
){}
