package com.tcs.service

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
//@ComponentScan(​​"com.tcs.service.controller"​​)
//@ComponentScan(basePackages = ["com.tcs.service.controller","com.tcs.service.service","com.tcs.service.repository"])
class UserApplication

fun main(args: Array<String>) {
    runApplication<UserApplication>(*args)
}
