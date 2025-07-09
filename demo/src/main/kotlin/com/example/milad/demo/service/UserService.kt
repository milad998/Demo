package com.example.milad.demo.service

import com.example.milad.demo.model.User
import com.example.milad.demo.repository.UserRepository
import com.example.milad.demo.security.JwtService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val userRepository: UserRepository,
    private val jwtService: JwtService,
    private val passwordEncoder: PasswordEncoder
) {
    fun register(username: String, password: String): String {
        if (userRepository.findByUsername(username) != null)
            throw RuntimeException("User already exists")
        val user = User(username = username, password = passwordEncoder.encode(password))
        userRepository.save(user)
        return jwtService.generateToken(user.username)
    }

    fun login(username: String, password: String): String {
        val user = userRepository.findByUsername(username)
            ?: throw RuntimeException("Invalid credentials")
        if (!passwordEncoder.matches(password, user.password))
            throw RuntimeException("Invalid credentials")
        return jwtService.generateToken(user.username)
    }
}
