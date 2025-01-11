package org.gdg_back.repository

import org.gdg_back.model.BasicInfo
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface BasicInfoRepository : JpaRepository<BasicInfo, UUID>{
    @EntityGraph(attributePaths = [
        "historicalContext",
        "legacy",
        "personalInfo",
        "professionalInfo",
        "otherRoles",
        "achievements",
        "personalityTraits",
        "influences",
        "keyEvents"
    ])
    fun findByName(name: String): BasicInfo?

    fun existsByName(name: String): Boolean
}