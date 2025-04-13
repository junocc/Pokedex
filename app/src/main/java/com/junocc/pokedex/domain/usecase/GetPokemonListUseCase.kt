package com.junocc.pokedex.domain.usecase

import com.junocc.pokedex.domain.model.Pokemon
import com.junocc.pokedex.domain.repository.PokemonRepository
import com.junocc.pokedex.domain.util.ResultType
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {

    suspend operator fun invoke(offset: Int, limit: Int): ResultType<List<Pokemon>> {
        return pokemonRepository.getPokemonList(offset, limit)
    }

}