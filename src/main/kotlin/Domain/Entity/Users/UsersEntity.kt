package com.practiceBlog.Domain.Entity.Users

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import lombok.ToString

@Entity @Data @ToString
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
data class UsersEntity (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var no: Int? = 0,
    var id: String? = null,
    var password: String? = null
)
