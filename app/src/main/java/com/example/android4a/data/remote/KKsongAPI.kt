package com.example.android4a.data.remote

import retrofit2.Call

import retrofit2.http.GET


interface KKsongAPI {
    @get:GET("KKsongsFakeAPI.json")
    val kkSongResponse: Call<RestKKsongResponse>
}
