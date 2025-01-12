package org.gdg_back.dto

import java.util.*

data class ChatMessageResponse(
    val messageId: UUID,
    val senderId: UUID?,
    val senderType: String,
    val message: String,
)