package com.example.android4a.presentation.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android4a.data.remote.KKsongAPI
import com.example.android4a.data.remote.RestKKsongResponse
import com.example.android4a.domain.entity.KKSong
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListViewModel(

) : ViewModel() {



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
        val call: Call<RestKKsongResponse>? = kkSongAPI?.kkSongResponse
        if(call!=null) {
            call.enqueue(object : Callback<RestKKsongResponse?> {
                override fun onResponse(
                    call: Call<RestKKsongResponse?>,
                    response: Response<RestKKsongResponse?>
                ) {
                    if (response.isSuccessful() && response.body() != null) {
                        val kkSongList = response.body()!!.results
                        apiCallLiveData.value = APICallSuccess(kkSongList)
                    }
                }

                override fun onFailure(call: Call<RestKKsongResponse?>?, t: Throwable) {
                    apiCallLiveData.value = APICallError
                }
            })
        }
    }




}