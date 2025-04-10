package com.junocc.pokedex.di

import com.junocc.pokedex.data.api.PokedexApiService
import com.junocc.pokedex.data.remote.PokemonRemoteDataSource
import com.junocc.pokedex.data.remote.PokemonRemoteDataSourceImpl
import com.junocc.pokedex.data.repository.PokemonRepositoryImpl
import com.junocc.pokedex.domain.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun providePokemonRepository(
        pokemonRemoteDataSource: PokemonRemoteDataSource
    ) : PokemonRepository {
        return PokemonRepositoryImpl(pokemonRemoteDataSource)
    }

    @Provides
    @ViewModelScoped
    fun providePokemonRemoteDataSource(
        apiService: PokedexApiService
    ) : PokemonRemoteDataSource{
        return PokemonRemoteDataSourceImpl(apiService)
    }

}