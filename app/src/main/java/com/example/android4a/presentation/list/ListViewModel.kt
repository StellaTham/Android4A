package com.example.android4a.presentation.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android4a.data.remote.KKsongAPI
import com.example.android4a.data.remote.RestKKsongResponse
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListViewModel : ViewModel() {



    val apiCallLiveData: MutableLiveData<APICallStatus> = MutableLiveData()
    fun makeApiCall() {

        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/StellaTham/Android4A/master/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val kkSongAPI: KKsongAPI = retrofit.create(KKsongAPI::class.java)
        kkSongAPI
            .kkSongResponse
            .enqueue(object : Callback<RestKKsongResponse?> {
            override fun onResponse(
                call: Call<RestKKsongResponse?>,
                response: Response<RestKKsongResponse?>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    //Retrieving the list from the API call
                    val kkSongList = response.body()!!.results
                    //Sending the list to display it
                    apiCallLiveData.value = APICallSuccess(kkSongList)
                }
            }

            override fun onFailure(call: Call<RestKKsongResponse?>?, t: Throwable) {
                apiCallLiveData.value = APICallError
            }
        })
    }




}