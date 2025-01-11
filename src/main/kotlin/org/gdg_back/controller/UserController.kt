package org.gdg_back.controller

import org.gdg_back.dto.SignInRequest
import org.gdg_back.dto.SignUpRequest
import org.gdg_back.model.User
import org.gdg_back.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class UserController(
    private val userService: UserService
) {
    @PostMapping("/sign-up")
    fun signUp(
        @RequestBody signUpRequest: SignUpRequest
    ): ResponseEntity<User> {
        return ResponseEntity.ok(userService.signUp(signUpRequest))
    }

    @PostMapping("/sign-in")
    fun signIn(
        @RequestBody signInRequest: SignInRequest
    ):ResponseEntity<User> {
        return ResponseEntity.ok(userService.signIn(signInRequest))
    }
}