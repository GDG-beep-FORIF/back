package org.gdg_back.controller

import org.gdg_back.service.ChatRoomService
import org.springframework.web.bind.annotation.RestController

@RestController
class ChatMessageController(
    private val chatRoomService: ChatRoomService
) {

}