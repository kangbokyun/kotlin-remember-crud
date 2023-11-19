package com.practiceBlog.Domain.Entity.User

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import lombok.ToString

@Entity @Data @ToString
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
data class UserEntity (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var no: Int? = 0,
    var id: String? = null,
    var password: String? = null
)
