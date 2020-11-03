package com.tcs.service.repository

import com.microsoft.azure.spring.data.cosmosdb.repository.ReactiveCosmosRepository
import com.tcs.service.model.User
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : ReactiveCosmosRepository<User, Int>{

}