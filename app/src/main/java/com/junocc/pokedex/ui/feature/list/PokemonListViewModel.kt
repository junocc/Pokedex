package com.junocc.pokedex.ui.feature.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.junocc.pokedex.domain.model.Pokemon
import com.junocc.pokedex.domain.usecase.GetPokemonListUseCase
import com.junocc.pokedex.domain.util.ResultType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val getPokemonListUseCase: GetPokemonListUseCase
) : ViewModel() {

    private val _pokemonListState = MutableStateFlow<List<Pokemon>>(emptyList())
    val pokemonListState = _pokemonListState.asStateFlow()

    init {
        getPokemonList()
    }

    fun getPokemonList() {
        viewModelScope.launch {
            when(val result = getPokemonListUseCase()) {
                is ResultType.Error -> {}
                is ResultType.Success -> {
                    _pokemonListState.value = result.data
                }
            }
        }

    }

}