package com.example.composeinstagram.login.data.network

import com.example.composeinstagram.login.data.network.response.LoginResponse
import retrofit2.Response
import retrofit2.http.GET

interface LoginClient {
    @GET("/v3/a2d9a685-68a5-4368-b924-096ae8506fbc")

    suspend fun login(): Response<LoginResponse>
}