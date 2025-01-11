package org.gdg_back.dto

import org.gdg_back.model.*
import java.util.*

data class PersonResponse(
    val id: UUID,
    val name: String,
    val birthDeath: String?,
    val era: String?,
    val nationality: String?,
    val gender: String?,
    val imageUrl: String?,
    val professionalInfo: List<ProfessionalInfoResponse>,
    val otherRoles: List<OtherRoleResponse>,
    val achievements: List<AchievementResponse>,
    val personalInfo: PersonalInfoResponse?,
    val personalityTraits: List<PersonalityTraitResponse>,
    val influences: List<InfluenceResponse>,
    val legacy: LegacyResponse?,
    val historicalContext: HistoricalContextResponse?,
    val keyEvents: List<KeyEventResponse>
) {
    companion object {
        fun from(entity: BasicInfo) = PersonResponse(
            id = entity.id,
            name = entity.name,
            birthDeath = entity.birthDeath,
            era = entity.era,
            nationality = entity.nationality,
            gender = entity.gender,
            imageUrl = entity.imageUrl,
            professionalInfo = entity.professionalInfo.map { ProfessionalInfoResponse.from(it) },
            otherRoles = entity.otherRoles.map { OtherRoleResponse.from(it) },
            achievements = entity.achievements.map { AchievementResponse.from(it) },
            personalInfo = entity.personalInfo?.let { PersonalInfoResponse.from(it) },
            personalityTraits = entity.personalityTraits.map { PersonalityTraitResponse.from(it) },
            influences = entity.influences.map { InfluenceResponse.from(it) },
            legacy = entity.legacy?.let { LegacyResponse.from(it) },
            historicalContext = entity.historicalContext?.let { HistoricalContextResponse.from(it) },
            keyEvents = entity.keyEvents.map { KeyEventResponse.from(it) }
        )
    }
    data class ProfessionalInfoResponse(
        val id: UUID,
        val primaryOccupation: String?
    ) {
        companion object {
            fun from(entity: ProfessionalInfo) = ProfessionalInfoResponse(
                id = entity.id,
                primaryOccupation = entity.primaryOccupation
            )
        }
    }

    data class OtherRoleResponse(
        val id: UUID,
        val roleName: String?
    ) {
        companion object {
            fun from(entity: OtherRole) = OtherRoleResponse(
                id = entity.id,
                roleName = entity.roleName
            )
        }
    }

    data class AchievementResponse(
        val id: UUID,
        val achievementName: String?
    ) {
        companion object {
            fun from(entity: MajorAchievement) = AchievementResponse(
                id = entity.id,
                achievementName = entity.achievementName
            )
        }
    }

    data class PersonalInfoResponse(
        val id: UUID,
        val education: String?,
        val background: String?
    ) {
        companion object {
            fun from(entity: PersonalInfo) = PersonalInfoResponse(
                id = entity.id,
                education = entity.education,
                background = entity.background
            )
        }
    }

    data class PersonalityTraitResponse(
        val id: UUID,
        val traitName: String?
    ) {
        companion object {
            fun from(entity: PersonalityTrait) = PersonalityTraitResponse(
                id = entity.id,
                traitName = entity.traitName
            )
        }
    }

    data class InfluenceResponse(
        val id: UUID,
        val influenceName: String?
    ) {
        companion object {
            fun from(entity: Influence) = InfluenceResponse(
                id = entity.id,
                influenceName = entity.influenceName
            )
        }
    }

    data class LegacyResponse(
        val id: UUID,
        val impact: String?,
        val modernSignificance: String?
    ) {
        companion object {
            fun from(entity: Legacy) = LegacyResponse(
                id = entity.id,
                impact = entity.impact,
                modernSignificance = entity.modernSignificance
            )
        }
    }

    data class HistoricalContextResponse(
        val id: UUID,
        val periodBackground: String?
    ) {
        companion object {
            fun from(entity: HistoricalContext) = HistoricalContextResponse(
                id = entity.id,
                periodBackground = entity.periodBackground
            )
        }
    }

    data class KeyEventResponse(
        val id: UUID,
        val eventDescription: String?
    ) {
        companion object {
            fun from(entity: KeyEvent) = KeyEventResponse(
                id = entity.id,
                eventDescription = entity.eventDescription
            )
        }
    }
}