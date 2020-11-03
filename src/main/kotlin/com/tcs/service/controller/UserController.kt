package com.tcs.service.controller

import com.microsoft.applicationinsights.TelemetryClient
import com.tcs.service.model.User
import com.tcs.service.service.UserService
import com.tcs.service.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.apache.logging.log4j.kotlin.logger
import org.springframework.http.ResponseEntity
import com.tcs.service.model.ServiceResponse


@RestController
@RequestMapping("/api/v1/acme")
class UserController(val userService: UserService, val userRepository: UserRepository) {
    val logger = logger()
    @Autowired
//    lateinit var telemetryClient: TelemetryClient

    @GetMapping("/user/{id}")
    fun getUserById(@PathVariable("id", required=true) id: Int ): ResponseEntity<ServiceResponse>{
        logger.info("URI /user/$id is triggered")
//        telemetryClient.trackEvent("URI /user/$id is triggered")
        return ResponseEntity.ok(ServiceResponse("200",
                "SUCCESS", userService.getUserById(id)))
    }

    @GetMapping("/users")
    fun getAllUsers(): List<User>? {
        logger.info("URI /user is triggered")
//        telemetryClient.trackEvent("URI /user is triggered")
        return userService.getAllUsers()
    }

    @PostMapping("/user")
    fun saveUser(@RequestBody user: User): ResponseEntity<ServiceResponse> {
        userService.saveUser(user)
        return ResponseEntity.ok(ServiceResponse("200",
                "SUCCESS", "Data Successfully Inserted"))
    }

/*    @PutMapping("/user/{id}")
    fun updateUser(){

    }

    @DeleteMapping("/user/{id}")
    fun deleteUser(){

    }*/
}