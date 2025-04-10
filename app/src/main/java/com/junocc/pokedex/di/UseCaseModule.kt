package com.junocc.pokedex.di

import com.junocc.pokedex.domain.repository.PokemonRepository
import com.junocc.pokedex.domain.usecase.GetPokemonListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    @ViewModelScoped
    fun provideGetPokemonList(pokemonRepository: PokemonRepository): GetPokemonListUseCase {
        return GetPokemonListUseCase(pokemonRepository)
    }
}