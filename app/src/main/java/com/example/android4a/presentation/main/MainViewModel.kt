package com.example.android4a.presentation.main

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android4a.domain.entity.User
import com.example.android4a.domain.usecase.CreateUserUseCase
import com.example.android4a.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.withTestContext
import kotlinx.coroutines.withContext

class MainViewModel (
    private val createUserUseCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase
): ViewModel(){


    val loginLiveData: MutableLiveData<LoginStatus> = MutableLiveData()
    val createLiveData: MutableLiveData<CreateStatus> = MutableLiveData()

    fun onClickedLogin(emailUser: String, passwordUser: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = getUserUseCase.invoke(emailUser, passwordUser)
            val loginStatus = if(user!=null){
                LoginSuccess(user.email, user.password)
            }else{
                LoginError
            }

            withContext(Dispatchers.Main){
                loginLiveData.value=loginStatus}
        }
    }

    fun onClickedCreate(emailUser: String, passwordUser: String) {
        viewModelScope.launch(Dispatchers.IO) {

            val result = createUserUseCase.invoke(User(emailUser, passwordUser))
            val createStatus = if(result.equals("Success")){
                CreateSuccess(emailUser, passwordUser)
            }else{
                CreateError
            }

            withContext(Dispatchers.Main){
                createLiveData.value=createStatus}
        }
    }
}