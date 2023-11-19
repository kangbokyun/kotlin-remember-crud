package com.practiceBlog.Controller.Main

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController {
    @GetMapping("/")
    fun BasePoint(): String {
        return "BasePoint Init"
    }
}