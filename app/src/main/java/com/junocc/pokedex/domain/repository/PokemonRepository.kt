package com.junocc.pokedex.domain.repository

import com.junocc.pokedex.domain.model.Pokemon
import com.junocc.pokedex.domain.util.ResultType

interface PokemonRepository {
    suspend fun getPokemonList(offset: Int, limit: Int) : ResultType<List<Pokemon>>
}