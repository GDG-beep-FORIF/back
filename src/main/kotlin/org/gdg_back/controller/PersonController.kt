package org.gdg_back.controller

import org.gdg_back.dto.PersonResponse
import org.gdg_back.service.PersonService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/persons")
class PersonController(
    private val personService: PersonService
) {

    @GetMapping
    fun getPersonInfo(@RequestParam name: String): PersonResponse {
        return personService.findByName(name)
    }

}