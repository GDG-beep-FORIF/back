package org.gdg_back.service

import jakarta.persistence.EntityNotFoundException
import org.gdg_back.dto.PersonResponse
import org.gdg_back.repository.BasicInfoRepository
import org.gdg_back.repository.ChatRoomRepository
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono


@Service
class PersonService (
    private val basicInfoRepository: BasicInfoRepository
){

    fun getPersonInfo(name: String): PersonResponse {
        val person = basicInfoRepository.findByName(name)
            ?: throw EntityNotFoundException("Person not found with name: $name")

        return PersonResponse.from(person)
    }

}