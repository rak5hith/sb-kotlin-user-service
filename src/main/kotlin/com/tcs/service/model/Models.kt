package com.tcs.service.model

import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document
import org.springframework.data.annotation.Id

/**
 * This class will contain all the DTO Objects
 */
@Document(collection = "users")
data class User(@Id val id: Int,
                val name: String,
                val email: String,
                val address: String)