package com.practiceBlog.Service.User

import com.practiceBlog.Domain.DTO.User.UserDTO
import com.practiceBlog.Domain.Entity.User.UserEntity
import com.practiceBlog.Domain.Repository.User.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.IllegalArgumentException

@Service
class UserService(
    @Autowired private val userRepository: UserRepository,
) {
    fun UserSignUp(userDTO: UserDTO): Boolean {
        userDTO.let {
            if (it.id.isNullOrEmpty())
                throw IllegalArgumentException("ID is Empty or Null")
            else if (it.password.isNullOrEmpty())
                throw IllegalArgumentException("PW is Empty or Null")
            val userEntity = UserEntity(
                id = it.id!!,
                password = it.password!!
            )
            userRepository.save(userEntity)
        }
        return true
    }

    @Transactional
    fun UserInfoUpdate(userDTO: UserDTO): Boolean {
        userDTO.no?.let { no ->
            userDTO.id.takeIf { it?.isNotEmpty()!! }?.let { id ->
                val user = userRepository.findById(no).orElseThrow { NoSuchElementException("no not found") }
                user.id = id
            } ?: run { throw IllegalArgumentException("id not found") }
            userDTO.password.takeIf { it?.isNotEmpty()!! }?.let { pw ->
                val user = userRepository.findById(no).orElseThrow { NoSuchElementException("no not found") }
                user.password = pw
            } ?: run { throw IllegalArgumentException("pw not found") }
        } ?: run { throw IllegalArgumentException("no not found") }
        return true
    }

    fun DeleteUser(userDTO: UserDTO): Boolean {
        userDTO.no?.let {
            userRepository.findById(it).ifPresentOrElse({ user ->
                userRepository.deleteById(it)
            }, {
                throw IllegalArgumentException("do not deleted")
            })
        } ?: run { throw IllegalArgumentException("no Not Found") }
        return true
    }
}