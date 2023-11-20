package com.practiceBlog.Service.Users

import com.practiceBlog.Domain.DTO.Users.UsersDTO
import com.practiceBlog.Domain.Entity.Users.UsersEntity
import com.practiceBlog.Domain.Repository.Users.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.IllegalArgumentException

@Service
class UsersService(
    @Autowired private val usersRepository: UsersRepository,
) {
    fun UserSignUp(usersDTO: UsersDTO): Boolean {
        usersDTO.let {
            if (it.id.isNullOrEmpty())
                throw IllegalArgumentException("ID is Empty or Null")
            else if (it.password.isNullOrEmpty())
                throw IllegalArgumentException("PW is Empty or Null")
            val usersEntity = UsersEntity(
                id = it.id!!,
                password = it.password!!
            )
            usersRepository.save(usersEntity)
        }
        return true
    }

    @Transactional
    fun UserInfoUpdate(usersDTO: UsersDTO): Boolean {
        usersDTO.no?.let { no ->
            usersDTO.id.takeIf { it?.isNotEmpty()!! }?.let { id ->
                val user = usersRepository.findById(no).orElseThrow { NoSuchElementException("no not found") }
                user.id = id
            } ?: run { throw IllegalArgumentException("id not found") }
            usersDTO.password.takeIf { it?.isNotEmpty()!! }?.let { pw ->
                val user = usersRepository.findById(no).orElseThrow { NoSuchElementException("no not found") }
                user.password = pw
            } ?: run { throw IllegalArgumentException("pw not found") }
        } ?: run { throw IllegalArgumentException("no not found") }
        return true
    }

    fun DeleteUser(usersDTO: UsersDTO): Boolean {
        usersDTO.no?.let {
            usersRepository.findById(it).ifPresentOrElse({ users ->
                usersRepository.deleteById(it)
            }, {
                throw IllegalArgumentException("do not deleted")
            })
        } ?: run { throw IllegalArgumentException("no Not Found") }
        return true
    }
}