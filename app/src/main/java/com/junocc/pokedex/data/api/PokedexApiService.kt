package com.junocc.pokedex.data.api

import com.junocc.pokedex.data.response.PokemonListResponse
import retrofit2.Response
import retrofit2.http.GET

interface PokedexApiService {

    @GET("pokemon")
    suspend fun getPokemons(): Response<PokemonListResponse>
}