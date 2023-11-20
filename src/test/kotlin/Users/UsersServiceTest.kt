package com.practiceBlog.Users

import com.practiceBlog.EntityHelper
import com.practiceBlog.Domain.DTO.Users.UsersDTO
import com.practiceBlog.Service.Users.UsersService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UsersServiceTest(
    @Autowired private val helper: EntityHelper,
    @Autowired private val usersService: UsersService,
) {
    @Test
    fun UserSignUpTest() {
        // given
        val dto = UsersDTO(
            id = "ㅎㅎ",
            password = "ㅋㅋ"
        )
        // when
        val result = usersService.UserSignUp(dto)

        // then
        Assertions.assertEquals(result, true)
        println("UsersServiceTest :: UserSignUpTest Success")
    }

    @Test
    fun UserUpdateTest() {
        // given
        val userEntity = helper.createUsers("gg", "gg")
        val userDTO = UsersDTO(userEntity.no, userEntity.id, userEntity.password)
        // when
        val result = usersService.UserInfoUpdate(userDTO)
        // then
        Assertions.assertEquals(result, true)
        println("UsersServiceTest :: UserUpdateTest Success")
    }

    @Test
    fun UserDeleteTest() {
        // given
        val userEntity = helper.createUsers("gg", "gg")
        val userDTO = UsersDTO(userEntity.no, userEntity.id, userEntity.password)
        // when
        val result = usersService.DeleteUser(userDTO)
        // then
        Assertions.assertEquals(result, true)
        println("UsersServiceTest :: UserDeleteTest Success")
    }
}