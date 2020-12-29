package com.example.android4a.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android4a.domain.entity.User
import com.example.android4a.domain.usecase.CreateUserUseCase
import com.example.android4a.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel (
    private val createUserUseCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase
): ViewModel(){

    //Mutable data for login and create account
    val loginLiveData: MutableLiveData<LoginStatus> = MutableLiveData()
    val createLiveData: MutableLiveData<CreateStatus> = MutableLiveData()

    fun onClickedLogin(emailUser: String, passwordUser: String) {
        viewModelScope.launch(Dispatchers.IO) {
            //Getting email and password entered
            val user = getUserUseCase.invoke(emailUser, passwordUser)
            val loginStatus = if(user!=null){
                //If the user exists in the database
                LoginSuccess(user.email, user.password)
            }else{
                LoginError
            }

            withContext(Dispatchers.Main){
                loginLiveData.value=loginStatus}
            //Sending the status
        }
    }

    fun onClickedCreate(emailUser: String, passwordUser: String) {
        viewModelScope.launch(Dispatchers.IO) {

            val result = createUserUseCase.invoke(User(emailUser, passwordUser))
            val createStatus = if(result == "Success"){
                //If the user has been successfully created
                CreateSuccess(emailUser, passwordUser)
            }else{
                CreateError
            }

            withContext(Dispatchers.Main){
                createLiveData.value=createStatus}
        }
    }
}