package com.junocc.pokedex.data.repository

import com.junocc.pokedex.data.remote.PokemonRemoteDataSource
import com.junocc.pokedex.domain.model.Pokemon
import com.junocc.pokedex.domain.repository.PokemonRepository
import com.junocc.pokedex.domain.util.ResultType
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val pokemonRemoteDataSource: PokemonRemoteDataSource
) : PokemonRepository {

    override suspend fun getPokemonList(offset: Int, limit: Int): ResultType<List<Pokemon>> {
        return when(val result = pokemonRemoteDataSource.getPokemonList(offset, limit)) {
            is ResultType.Success -> ResultType.Success(result.data.results)
            is ResultType.Error -> result
        }
    }

}