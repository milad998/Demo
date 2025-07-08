package com.example.milad.demo.controller

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class HelloController{
  @GetMapping("/hello")
  fun sayHello():String = "Hello"
}
