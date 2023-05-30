package com.example.gameapp.presentation.gameDetailsViewModel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gameapp.Resource
import com.example.gameapp.data.Games
import com.example.gameapp.domain.GameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val gameRepository: GameRepository
) : ViewModel() {

    val gameId = savedStateHandle.get<Int>("gameId") ?: 0

    private val _game = MutableStateFlow<Games?>(null)
    val game = _game.asStateFlow()

    init {
        viewModelScope.launch {
            getGame()
        }

        viewModelScope.launch {
            game.collect{
                Log.v("MYTAG", it.toString())
            }
        }
    }

    suspend fun getGame() {

        delay(500)
        val result = gameRepository.getGameById(gameId)
        if (result is Resource.Success) {
            _game.value = result.data!!
        }
    }
}