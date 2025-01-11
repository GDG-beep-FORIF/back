package org.gdg_back.dto

import java.util.*

data class CreateChatRoomResponse(
    val roomId: UUID,
    val status: String,
    val personCount: Int
)
