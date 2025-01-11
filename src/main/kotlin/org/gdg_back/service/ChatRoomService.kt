package org.gdg_back.service

import org.gdg_back.dto.CreateChatRoomRequest
import org.gdg_back.dto.CreateChatRoomResponse
import org.gdg_back.model.BasicInfo
import org.gdg_back.model.ChatRoom
import org.gdg_back.model.User
import org.gdg_back.repository.BasicInfoRepository
import org.gdg_back.repository.ChatRoomRepository
import org.gdg_back.repository.UserRepository
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.client.RestTemplate

@Service
class ChatRoomService(
    private val chatRoomRepository: ChatRoomRepository,
    private val basicInfoRepository: BasicInfoRepository,
    private val userRepository: UserRepository,
    private val restTemplate: RestTemplate
    ) {

    @Transactional
    fun createChatRoom(request: CreateChatRoomRequest): CreateChatRoomResponse {
        // 1. User 존재 여부 확인
        val user: User = userRepository.findById(request.userId)
            .orElseThrow { IllegalArgumentException("User with ID ${request.userId} not found") }

        // 2. BasicInfo 엔티티 가져오기 또는 생성
        val persons: MutableSet<BasicInfo> = mutableSetOf()
        for (name in request.personNames) {
            if(!basicInfoRepository.existsByName(name))
                callPersonaGenerator(name)
            val person = basicInfoRepository.findByName(name)
                ?: throw IllegalArgumentException("Person with name $name not found")
            persons.add(person)
        }

        // 3. ChatRoom 생성
        val chatRoom = ChatRoom(
            title = request.title,
            status = "ACTIVE",
            summary = "Summary of chat room",
            user = user,
            persons = persons
        )

        // 4. ChatRoom 저장
        val savedChatRoom = chatRoomRepository.save(chatRoom)

        val response = CreateChatRoomResponse(
            roomId = savedChatRoom.id,
            status = savedChatRoom.status,
            personCount = savedChatRoom.persons.size
        )

        return response
    }

    fun callPersonaGenerator(name: String) {
        val url = "http://147.47.236.54:8000/persona_generator"

        val headers = HttpHeaders().apply {
            contentType = MediaType.APPLICATION_JSON
        }
        val requestBody = mapOf("name" to name)
        val entity = HttpEntity(requestBody, headers)

        // POST 요청 보내기
        try {
            restTemplate.postForObject(url, entity, Void::class.java)
        } catch (ex: Exception) {
            throw IllegalArgumentException("Failed to call persona generator")
        }
    }

}