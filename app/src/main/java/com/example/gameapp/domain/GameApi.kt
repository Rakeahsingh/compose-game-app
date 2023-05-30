package com.example.gameapp.domain

import com.example.gameapp.data.Games
import com.example.gameapp.di.Constants.END_POINT
import com.example.gameapp.di.Constants.END_POINT_GAME
import retrofit2.http.GET
import retrofit2.http.Query

interface GameApi {

    @GET(END_POINT)
    suspend fun getGames(): List<Games>

    @GET(END_POINT_GAME)
    suspend fun getGameById(
        @Query("id") id: Int
    ): Games
}