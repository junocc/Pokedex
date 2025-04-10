package com.junocc.pokedex.data.response

import com.junocc.pokedex.domain.model.Pokemon

data class PokemonListResponse(
    val count: Long,
    val next: String,
    val previous: Any?,
    val results: List<Pokemon>,
)
