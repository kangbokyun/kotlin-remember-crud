package com.practiceBlog

import com.practiceBlog.Domain.Entity.Users.UsersEntity
import com.practiceBlog.Domain.Repository.Users.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class EntityHelper(
    @Autowired private val usersRepository: UsersRepository
) {
    fun createUsers(id: String, pw: String): UsersEntity {
        val usersEntity = UsersEntity(id = id, password = pw,)
        return usersRepository.save(usersEntity)
    }
}