package org.gdg_back.repository

import org.gdg_back.model.ChatRoom
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ChatRoomRepository : JpaRepository<ChatRoom, UUID>
