package com.porfirio.mvvmdm.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.porfirio.mvvmdm.data.remote.AnimeProvider
import com.porfirio.mvvmdm.data.remote.model.AnimeDto
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
// vamos a crear nuestros contenedores observables

    private val _anime = MutableLiveData<AnimeDto>() //versión mutable y privada, se puede modificar
    val anime: LiveData<AnimeDto> = _anime //LiveData regular (non mutable publica), solo se lee

    private val _test = MutableLiveData<String>()
    val test: LiveData<String> = _test

    fun updateAnimeRestApi() {
        viewModelScope.launch {
            val animeProvided = AnimeProvider.getAnimeRestApi()
            _anime.postValue(animeProvided)
        }
    }
}