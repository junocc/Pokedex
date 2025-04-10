package com.junocc.pokedex.domain.repository

import com.junocc.pokedex.domain.model.Pokemon
import com.junocc.pokedex.domain.util.ResultType

interface PokemonRepository {
    suspend fun getPokemonList() : ResultType<List<Pokemon>>
}