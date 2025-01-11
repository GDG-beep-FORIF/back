package org.gdg_back.dto

data class SignUpRequest(
    val email: String,
    val password: String,
    val username: String
)
