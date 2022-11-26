package ar.edu.unlam.tallerapp.android

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.tallerapp.Character
import ar.edu.unlam.tallerapp.CharactersService
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CharactersViewModel(
    private val charactersService: CharactersService
) : ViewModel() {

    private val _screenState: MutableStateFlow<ScreenState> = MutableStateFlow(ScreenState.Loading)
    val screenState: Flow<ScreenState> = _screenState

    private val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        Log.d("CharactersViewModel", "Error retrieving characters: ${throwable.message}")
    }

    init {
        viewModelScope.launch(coroutineExceptionHandler) {
                val list = charactersService.
                getCharacters()
                _screenState.value = ScreenState.ShowCharacters(list)
        /*runCatching{

        }.onSuccess{

            }.onFailure{

            }
            val list = charactersService.
            getCharacters()
            _screenState.value = ScreenState.ShowCharacters(list)*/
        }
    }

}

sealed class ScreenState {

    object Loading : ScreenState()

    class ShowCharacters(val list: List<Character>) : ScreenState()
}