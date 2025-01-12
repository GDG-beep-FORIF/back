package org.gdg_back.controller

import org.gdg_back.dto.ChatRoomResponse
import org.gdg_back.dto.CreateChatRoomRequest
import org.gdg_back.dto.CreateChatRoomResponse
import org.gdg_back.model.ChatRoom
import org.gdg_back.service.ChatRoomService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/chat-rooms")
class ChatRoomController(
    private val chatRoomService: ChatRoomService
) {

    @PostMapping
    fun createChatRoom(
        @RequestBody createChatRoomRequest: CreateChatRoomRequest
    ): ResponseEntity<CreateChatRoomResponse> {
        return ResponseEntity(chatRoomService.createChatRoom(createChatRoomRequest), HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun getChatRoom(@PathVariable id: UUID): ResponseEntity<ChatRoomResponse> {
        return ResponseEntity(chatRoomService.getChatRoom(id), HttpStatus.OK)
    }

}