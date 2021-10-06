package com.example.hilt.di

import com.example.hilt.service.ApiService
import com.example.hilt.service.ConfigManager
import com.example.hilt.service.MovieService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideApiServiceRetrofit(): ApiService {

        val okHttpClient = OkHttpClient().newBuilder()
            .connectTimeout(8, TimeUnit.SECONDS)
            .writeTimeout(8, TimeUnit.SECONDS)
            .readTimeout(8, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    fun provideMovieService(apiService: ApiService): MovieService {
        return MovieService(apiService)
    }

    @Provides
    fun providesConfigManager(movieService: MovieService): ConfigManager {
        return ConfigManager(movieService)
    }
}