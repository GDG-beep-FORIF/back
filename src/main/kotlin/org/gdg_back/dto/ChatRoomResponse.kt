package org.gdg_back.dto

data class ChatRoomResponse(
    val summary: String?,
    val chatMessage: List<ChatMessageResponse>
)
