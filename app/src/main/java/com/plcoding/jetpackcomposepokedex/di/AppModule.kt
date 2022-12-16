package com.plcoding.jetpackcomposepokedex.di

import com.plcoding.jetpackcomposepokedex.data.remote.PokemonApi
import com.plcoding.jetpackcomposepokedex.repository.PokemonRepository
import com.plcoding.jetpackcomposepokedex.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providePokemonRepo(
        api: PokemonApi
    ) = PokemonRepository(api)

    @Singleton
    @Provides
    fun providePokemonApi(): PokemonApi {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.baseUrl)
            .build()
            .create(PokemonApi::class.java)
    }
}