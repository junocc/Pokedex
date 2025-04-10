package com.junocc.pokedex.data.remote

import com.junocc.pokedex.data.api.PokedexApiService
import com.junocc.pokedex.domain.model.Pokemon
import javax.inject.Inject

class PokemonRemoteDataSourceImpl @Inject constructor(
    val pokedexApiService: PokedexApiService
): PokemonRemoteDataSource {

    override suspend fun getPokemonList(): List<Pokemon> {
        return try {
            pokedexApiService.getPokemons().body()!!.results
        } catch (t: Throwable) {
            return listOf()
        }
    }

}