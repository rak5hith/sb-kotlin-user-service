package com.tcs.service.component

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.nhaarman.mockito_kotlin.whenever
import com.tcs.service.model.User
import com.tcs.service.service.UserService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import java.io.File

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension::class, MockitoExtension::class)

class UserControllerTest {
    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var service: UserService

    /**
     * Method for preparing stub  data from sample json
     **/
    fun getUserObject(): User {
        val mapper = jacksonObjectMapper()
        mapper.registerKotlinModule()
        val jsonString: String = File("./src/test/resources/contracts/sample.json").readText(Charsets.UTF_8)
        val value: User = mapper.readValue<User>(jsonString)
        return value
    }

    /**
     * Preparing Mock Stub For service class
     **/
    @BeforeEach
    fun setup() {
        whenever(service.getUserById(101)).thenAnswer { getUserObject() }
    }

    /**
     * Test Method  for Controller Get Endpoint
     * Service call is mocked
     **/
    @Test
    fun getUserByIdTest() {
      /*  var expected = File("./src/test/resources/contracts/modelresponse.json").readText(Charsets.UTF_8)
        var result: MvcResult =
                mockMvc.get("/api/v1/service-template/model").andExpect { status { isOk } }.andReturn()
        JSONAssert.assertEquals(expected, result.response.contentAsString, false)*/

        assert(service.getUserById(101).name.equals("Abc"))
    }
}