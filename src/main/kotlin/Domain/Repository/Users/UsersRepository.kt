package com.practiceBlog.Domain.Repository.Users

import com.practiceBlog.Domain.Entity.Users.UsersEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsersRepository: JpaRepository<UsersEntity, Int> {
}