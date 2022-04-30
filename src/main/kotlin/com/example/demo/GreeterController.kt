package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("greeter")
class GreeterController {
//    @Autowired
//    private lateinit var greeter: Greeter
    var greeter: Greeter? = null
        @Autowired
        set(value) {
            field = value
        }
    @GetMapping("/hello")
    fun hello(@RequestParam("name") name: String): HelloResponse {
        return HelloResponse("Hello ${name}")
    }
    @GetMapping("/hello/byservice/{name}")
    fun helloByService(@PathVariable("name") name: String) : HelloResponse {
        val message = greeter?.sayHello(name)
        return HelloResponse(message)
    }
}



