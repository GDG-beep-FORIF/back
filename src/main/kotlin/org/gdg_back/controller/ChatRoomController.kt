package org.gdg_back.controller

import org.gdg_back.dto.CreateChatRoomRequest
import org.gdg_back.dto.CreateChatRoomResponse
import org.gdg_back.service.ChatRoomService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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

}