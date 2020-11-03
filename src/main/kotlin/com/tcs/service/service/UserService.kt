package com.tcs.service.service

import com.tcs.service.error.customexception.DataNotFoundException
import com.tcs.service.model.User
import com.tcs.service.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(val userRepository: UserRepository ){

    val datanfmsg = "No Data Found"
    fun saveUser(user: User){
        userRepository.save(user).block()
    }

    fun getUserById(id: Int): User {
        return userRepository.findById(id).block()?: throw DataNotFoundException(datanfmsg)

    }

    fun getAllUsers(): List<User>? {
        return userRepository.findAll().collectList().block()?: throw DataNotFoundException(datanfmsg)
    }


}