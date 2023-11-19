package com.practiceBlog.Controller.User

import com.practiceBlog.Domain.DTO.User.UserDTO
import com.practiceBlog.Service.User.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    @Autowired private val userService: UserService
) {
    @PostMapping("/user/signup")
    fun UserSignUp(
        @RequestBody userDTO: UserDTO,
    ): ResponseEntity<HttpStatus> {
        val result = userService.UserSignUp(userDTO)
        return ResponseEntity.ok().body(HttpStatus.OK)
    }

    @PutMapping("/user/update-all-info")
    fun UserInfoUpdate(
        @RequestBody userDTO: UserDTO,
    ): ResponseEntity<HttpStatus> {
        val result = userService.UserInfoUpdate(userDTO)
        return ResponseEntity.ok().body(HttpStatus.OK)
    }

    @DeleteMapping("/user/delete")
    fun UserDelete(
        @RequestBody userDTO: UserDTO,
    ) :ResponseEntity<HttpStatus> {
        userService.DeleteUser(userDTO)
        return ResponseEntity.ok().body(HttpStatus.OK)
    }
}