package com.example.milad.demo.controller

import com.example.milad.demo.service.AuthService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/auth")
class AuthController(private val authService: AuthService) {

    data class AuthRequest(val username: String, val password: String)

    @PostMapping("/register")
    fun register(@RequestBody req: AuthRequest): String {
        return authService.register(req.username, req.password)
    }

    @PostMapping("/login")
    fun login(@RequestBody req: AuthRequest): String {
        return authService.login(req.username, req.password)
    }
}
