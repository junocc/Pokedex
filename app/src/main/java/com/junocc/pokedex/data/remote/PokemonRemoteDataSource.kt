package com.junocc.pokedex.data.remote

import com.junocc.pokedex.data.network.response.PokemonListResponse
import com.junocc.pokedex.domain.util.ResultType

interface PokemonRemoteDataSource {
    suspend fun getPokemonList(offset: Int, limit: Int) : ResultType<PokemonListResponse>
}