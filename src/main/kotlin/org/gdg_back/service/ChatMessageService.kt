package org.gdg_back.service

import org.gdg_back.repository.ChatMessageRepository
import org.springframework.stereotype.Service

@Service
class ChatMessageService(
    private val chatMessageRepository: ChatMessageRepository
) {
}