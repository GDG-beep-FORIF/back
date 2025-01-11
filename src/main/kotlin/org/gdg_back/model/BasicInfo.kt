package org.gdg_back.model

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "basic_info")
class BasicInfo(
    @Id
    @Column(name = "person_id", updatable = false, nullable = false)
    val id: UUID = UUID.randomUUID(),

    @Column(nullable = false)
    val name: String,

    @Column(name = "birth_death")
    val birthDeath: String? = null,

    val era: String? = null,
    val nationality: String? = null,
    val gender: String? = null,

    @Column(name = "image_url")
    val imageUrl: String? = null,

    @OneToMany(mappedBy = "person", cascade = [CascadeType.ALL], orphanRemoval = true)
    val professionalInfo: MutableSet<ProfessionalInfo> = mutableSetOf(),

    @OneToMany(mappedBy = "person", cascade = [CascadeType.ALL], orphanRemoval = true)
    val otherRoles: MutableSet<OtherRole> = mutableSetOf(),

    @OneToMany(mappedBy = "person", cascade = [CascadeType.ALL], orphanRemoval = true)
    val achievements: MutableSet<MajorAchievement> = mutableSetOf(),

    @OneToOne(mappedBy = "person", cascade = [CascadeType.ALL], orphanRemoval = true)
    @JsonManagedReference
    val personalInfo: PersonalInfo? = null,

    @OneToMany(mappedBy = "person", cascade = [CascadeType.ALL], orphanRemoval = true)
    val personalityTraits: MutableSet<PersonalityTrait> = mutableSetOf(),

    @OneToMany(mappedBy = "person", cascade = [CascadeType.ALL], orphanRemoval = true)
    val influences: MutableSet<Influence> = mutableSetOf(),

    @OneToOne(mappedBy = "person", cascade = [CascadeType.ALL], orphanRemoval = true)
    val legacy: Legacy? = null,

    @OneToOne(mappedBy = "person", cascade = [CascadeType.ALL], orphanRemoval = true)
    val historicalContext: HistoricalContext? = null,

    @OneToMany(mappedBy = "person", cascade = [CascadeType.ALL], orphanRemoval = true)
    val keyEvents: MutableSet<KeyEvent> = mutableSetOf(),

    @ManyToMany(mappedBy = "persons")
    val chatRooms: MutableSet<ChatRoom> = mutableSetOf()
) {
}
