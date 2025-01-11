package org.gdg_back.service

import jakarta.persistence.EntityNotFoundException
import org.gdg_back.dto.PersonResponse
import org.gdg_back.repository.BasicInfoRepository
import org.springframework.stereotype.Service
import java.util.UUID


@Service
class PersonService (
    private val basicInfoRepository: BasicInfoRepository,
    private val chatRoomService: ChatRoomService
){

    fun getPersonInfo(name: String): PersonResponse {
        if(!basicInfoRepository.existsByName(name))
            chatRoomService.callPersonaGenerator(name)

        val person = basicInfoRepository.findByName(name) ?: throw EntityNotFoundException("Person not found")

        return PersonResponse.from(person)
    }

    fun getPersonInfo(id: UUID): PersonResponse {
        val person = basicInfoRepository.findById(id)
            .orElseThrow { EntityNotFoundException("Person not found") }
        return PersonResponse.from(person)
    }

}