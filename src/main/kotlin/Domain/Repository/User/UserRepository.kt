package com.practiceBlog.Domain.Repository.User

import com.practiceBlog.Domain.Entity.User.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<UserEntity, Int> {
}