package com.example.android4a.domain.useCase

import com.example.android4a.data.repository.UserRepository
import com.example.android4a.domain.entity.User
import com.example.android4a.domain.usecase.CreateUserUseCase
import com.example.android4a.domain.usecase.GetUserUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetUserUseCaseTest{
    private val userRepository: UserRepository = mockk()
    private val classUnderTest = GetUserUseCase(userRepository)

    @Test
    fun `invoke() with invalid email`(){
        runBlocking {
            //GIVEN
            val email = ""
            coEvery {
                userRepository.getUser(email)
            }returns null

            //WHEN
            val result = classUnderTest.invoke(email)

                //THEN
            coVerify(exactly = 1) { userRepository.getUser(email)}
            assertEquals(result, null)
         }
    }

    @Test
    fun `invoke() with valid email`(){
        runBlocking {
            //GIVEN
            val email = "a@b.com"
            val expectedUser =User("a@b.com")
            coEvery {
                userRepository.getUser(email)
            }returns expectedUser

            //WHEN
            val result = classUnderTest.invoke(email)

            //THEN
            coVerify(exactly = 1) { userRepository.getUser(email)}
            assertEquals(result, expectedUser)
        }
    }
}