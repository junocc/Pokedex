package com.junocc.pokedex.data.remote

import com.junocc.pokedex.domain.model.Pokemon

interface PokemonRemoteDataSource {
    suspend fun getPokemonList() : List<Pokemon>
}