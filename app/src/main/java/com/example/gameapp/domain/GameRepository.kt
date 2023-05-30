package com.example.gameapp.domain

import com.example.gameapp.Resource
import com.example.gameapp.data.Games
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject


@ActivityScoped
class GameRepository @Inject constructor(
    private val apiInterface: GameApi
) {

    suspend fun getGames(): Resource<List<Games>> {
        val response = try {
            apiInterface.getGames()
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured: ${e.localizedMessage}")
        }

        return Resource.Success(response)
    }

    suspend fun getGameById(id: Int): Resource<Games> {
        val response = try {
            apiInterface.getGameById(id)
        }catch (e: Exception){
            return Resource.Error("An unknown error occured: ${e.localizedMessage}")
        }

        return Resource.Success(response)
    }
}