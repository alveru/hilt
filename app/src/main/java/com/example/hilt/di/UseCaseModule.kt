package com.example.hilt.di

import com.example.hilt.service.MovieService
import com.example.hilt.usecase.GetMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object UseCaseModule {

    @Provides
    fun providesGetMoviesUseCase(movieService: MovieService): GetMoviesUseCase {
        return GetMoviesUseCase(movieService)
    }

}