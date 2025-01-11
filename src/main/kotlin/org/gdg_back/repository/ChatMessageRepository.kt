package org.gdg_back.repository

import org.gdg_back.model.ChatMessage
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ChatMessageRepository : JpaRepository<ChatMessage, UUID>