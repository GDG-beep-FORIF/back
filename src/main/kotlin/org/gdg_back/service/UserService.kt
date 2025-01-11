package org.gdg_back.service

import org.gdg_back.dto.SignInRequest
import org.gdg_back.dto.SignInResponse
import org.gdg_back.dto.SignUpRequest
import org.gdg_back.model.User
import org.gdg_back.repository.UserRepository

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository
) {

    @Transactional
    fun signUp(request: SignUpRequest){
        if (userRepository.existsByEmail(request.email)) {
            throw IllegalArgumentException("Email already exists")
        }

        val user = User(
            email = request.email,
            passwordHash = request.password,
            username = request.username
        )

        // save 대신 saveAndFlush 사용
        userRepository.saveAndFlush(user)
    }

    fun signIn(signInRequest: SignInRequest): SignInResponse {
        val user = userRepository.findByEmail(signInRequest.email)
            ?: throw IllegalArgumentException("User not found")

        if (user.passwordHash != signInRequest.password) {
            throw IllegalArgumentException("Password is incorrect")
        }

        return SignInResponse(
            email = user.email,
            userId = user.id.toString()
        )
    }


}