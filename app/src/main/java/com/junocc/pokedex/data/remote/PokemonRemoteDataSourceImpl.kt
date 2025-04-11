package com.junocc.pokedex.data.remote

import com.junocc.pokedex.data.api.PokedexApiService
import com.junocc.pokedex.data.network.response.PokemonListResponse
import com.junocc.pokedex.data.network.safeApiCall
import com.junocc.pokedex.domain.util.ResultType
import javax.inject.Inject

class PokemonRemoteDataSourceImpl @Inject constructor(
    val pokedexApiService: PokedexApiService
): PokemonRemoteDataSource {

    override suspend fun getPokemonList(): ResultType<PokemonListResponse> {
        return safeApiCall {
            pokedexApiService.getPokemons()
        }
    }

}