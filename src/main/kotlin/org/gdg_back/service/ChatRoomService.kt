package org.gdg_back.service

import org.gdg_back.model.ChatRoom
import org.gdg_back.repository.ChatRoomRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ChatRoomService(
    private val chatRoomRepository: ChatRoomRepository
) {

}