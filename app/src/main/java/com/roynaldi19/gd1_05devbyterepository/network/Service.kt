package com.roynaldi19.gd1_05devbyterepository.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface DevbyteService {
    @GET("devbytes")
    suspend fun getPlaylist(): NetworkVideoContainer
}

object DevByteNetwork {
    private val retrofit = Retrofit.Builder()
            .baseUrl("https://android-kotlin-fun-mars-server.appspot.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    val devbytes = retrofit.create(DevbyteService::class.java)

}


