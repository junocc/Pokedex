package com.junocc.pokedex.ui.feature.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.junocc.pokedex.domain.model.Pokemon
import com.junocc.pokedex.domain.usecase.GetPokemonListUseCase
import com.junocc.pokedex.domain.util.ResultType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

const val PAGE = 20

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val getPokemonListUseCase: GetPokemonListUseCase
) : ViewModel() {

    private val _pokemonListState = MutableStateFlow<List<Pokemon>>(emptyList())
    val pokemonListState = _pokemonListState.asStateFlow()

    private val _loadingState = MutableStateFlow(false)
    val loadingState = _loadingState.asStateFlow()

    private var currentPage = 0


    init {
        getPokemonList()
    }

    fun getPokemonList() {
        viewModelScope.launch {
            _loadingState.value = true
            delay(5000)
            val offset = currentPage * PAGE
            when(val result = getPokemonListUseCase(offset, PAGE)) {
                is ResultType.Error -> {}
                is ResultType.Success -> {
                    _pokemonListState.value += result.data
                    currentPage++
                }
            }
            _loadingState.value = false
        }

    }

}