package com.example.milad.demo.controller

import com.example.milad.demo.model.User
import com.example.milad.demo.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(private val userService: UserService) {

    @GetMapping
    fun getAll(): List<User> = userService.getAllUsers()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): User = userService.getUserById(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody user: User): User = userService.createUser(user)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody user: User): User =
        userService.updateUser(id, user)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) = userService.deleteUser(id)
}
