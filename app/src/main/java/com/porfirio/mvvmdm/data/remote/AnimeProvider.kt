package com.porfirio.mvvmdm.data.remote

import com.porfirio.mvvmdm.data.remote.model.AnimeDto
//import kotlinx.coroutines.DefaultExecutor.delay

class AnimeProvider {

    companion object{
        private val animes = mutableListOf<AnimeDto>()

        init{
            for(i in 1..40){
                val animeTmp = AnimeDto(i.toLong(),"Titulo $i", "Tipo $i","Fecha $i")
                animes.add(animeTmp)
            }
        }
       suspend fun getAnimeRestApi(): AnimeDto{
            val position = (0..39).random()
           // delay(2000)
            return animes[position]
        }
    }
}