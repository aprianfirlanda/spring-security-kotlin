package com.aprianfirlanda

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@SpringBootApplication
class SpringSecurityKotlinApplication

fun main(args: Array<String>) {
	runApplication<SpringSecurityKotlinApplication>(*args)
}

@RestController
class UserController {

	@GetMapping("/me")
	suspend fun me(@AuthenticationPrincipal principal: Principal): Profile = Profile(principal.name)
}

data class Profile(val username: String)