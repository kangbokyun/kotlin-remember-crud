package com.practiceBlog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PracticeBlogApplication

fun main(args: Array<String>) {
    runApplication<PracticeBlogApplication>(*args)
}