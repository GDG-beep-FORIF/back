package org.gdg_back.service

import jakarta.persistence.EntityNotFoundException
import org.gdg_back.dto.PersonResponse
import org.gdg_back.repository.BasicInfoRepository
import org.springframework.stereotype.Service

@Service
class PersonService (
    private val basicInfoRepository: BasicInfoRepository
){
    fun findByName(name: String): PersonResponse {
        val person = basicInfoRepository.findByName(name)
            ?: throw EntityNotFoundException("Person not found with name: $name")

        return PersonResponse.from(person)
    }
}