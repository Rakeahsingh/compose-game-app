package com.example.gameapp.di

import com.example.gameapp.di.Constants.BASE_URL
import com.example.gameapp.domain.GameApi
import com.example.gameapp.domain.GameRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object GameModule {

    @Singleton
    @Provides
    fun provideRetrofit() : GameApi{
        val okHttp = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttp)
            .build()
            .create(GameApi::class.java)
    }

    @Singleton
    @Provides
    fun provideGameRepository(gameApi: GameApi): GameRepository {
        return GameRepository(gameApi)
    }

}