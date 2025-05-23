package com.junocc.pokedex.domain.model

data class Pokemon(val id: String, val name: String, val url: String) {


    fun getImageUrl(): String {
        val index = url.split("/".toRegex()).dropLast(1).last()
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/" +
                "pokemon/other/official-artwork/$index.png"
    }
}
