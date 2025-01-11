package org.gdg_back.dto

import java.util.*

data class CreateChatRoomRequest(
    val title: String,
    val userId: UUID,
    val personNames: List<String>
)