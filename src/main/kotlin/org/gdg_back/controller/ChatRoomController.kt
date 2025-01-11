package org.gdg_back.controller

import org.gdg_back.model.ChatRoom
import org.gdg_back.service.ChatRoomService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/chat-rooms")
class ChatRoomController(
    private val chatRoomService: ChatRoomService
) {

}