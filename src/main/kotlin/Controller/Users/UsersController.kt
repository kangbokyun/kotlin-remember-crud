package com.practiceBlog.Controller.User

import com.practiceBlog.Domain.DTO.Users.UsersDTO
import com.practiceBlog.Service.Users.UsersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UsersController(
    @Autowired private val usersService: UsersService
) {
    @PostMapping("/user/signup")
    fun UserSignUp(
        @RequestBody usersDTO: UsersDTO,
    ): ResponseEntity<HttpStatus> {
        val result = usersService.UserSignUp(usersDTO)
        return ResponseEntity.ok().body(HttpStatus.OK)
    }

    @PutMapping("/user/update-all-info")
    fun UserInfoUpdate(
        @RequestBody usersDTO: UsersDTO,
    ): ResponseEntity<HttpStatus> {
        val result = usersService.UserInfoUpdate(usersDTO)
        return ResponseEntity.ok().body(HttpStatus.OK)
    }

    @DeleteMapping("/user/delete")
    fun UserDelete(
        @RequestBody usersDTO: UsersDTO,
    ) :ResponseEntity<HttpStatus> {
        usersService.DeleteUser(usersDTO)
        return ResponseEntity.ok().body(HttpStatus.OK)
    }
}