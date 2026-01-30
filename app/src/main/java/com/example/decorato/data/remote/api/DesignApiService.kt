package com.example.decorato.data.remote.api

import com.example.decorato.data.remote.dto.DesignDto
import com.example.decorato.data.remote.dto.RecentlyWatchedDesignDto
import retrofit2.http.GET

interface DesignApiService {

    @GET("designs/popular")
    suspend fun getPopularDesigns(): List<DesignDto>

    @GET("designs/recently-watched")
    suspend fun getRecentlyWatchedDesigns(): List<RecentlyWatchedDesignDto>
}