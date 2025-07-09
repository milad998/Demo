package com.example.milad.demo.service

import com.example.milad.demo.model.User
import com.example.milad.demo.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun getAllUsers(): List<User> = userRepository.findAll()

    fun getUserById(id: Long): User =
        userRepository.findById(id).orElseThrow { NoSuchElementException("User not found") }

    fun createUser(user: User): User = userRepository.save(user)

    fun updateUser(id: Long, updatedUser: User): User {
        val existingUser = getUserById(id)
        val userToSave = existingUser.copy(
            name = updatedUser.name,
            email = updatedUser.email
        )
        return userRepository.save(userToSave)
    }

    fun deleteUser(id: Long) {
        userRepository.deleteById(id)
    }
}
