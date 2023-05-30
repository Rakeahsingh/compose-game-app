package com.example.gameapp.domain


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gameapp.Resource
import com.example.gameapp.data.Games
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class GameViewModel
@Inject
constructor(
    private val repository: GameRepository
) : ViewModel()
{

    var loading = mutableStateOf(false)
    private var _gameList = MutableStateFlow<List<Games>>(emptyList())
    var gameList : StateFlow<List<Games>> = _gameList.asStateFlow()


    init {
        viewModelScope.launch {
            getGames()
        }
    }

    suspend fun getGames(): Resource<List<Games>>{
        loading.value = true
        val result = repository.getGames()
        if ( result is Resource.Success){

            _gameList.value = result.data!!
        }

        return  result
    }

}