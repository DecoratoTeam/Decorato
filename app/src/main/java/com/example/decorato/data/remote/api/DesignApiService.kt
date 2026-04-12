package com.example.decorato.data.remote.api

import com.example.decorato.data.remote.dto.DesignDto
import com.example.decorato.data.remote.dto.RecentlyWatchedDesignDto
import retrofit2.http.GET
import retrofit2.http.Path

interface DesignApiService {

    @GET("designs/popular")
    suspend fun getPopularDesigns(): List<DesignDto>

    @GET("designs/recently-watched")
    suspend fun getRecentlyWatchedDesigns(): List<RecentlyWatchedDesignDto>

    @GET("ShowcaseDesign/by-style/{styleId}")
    suspend fun getDesignsByStyle(
        @Path("styleId") styleId: String
    ): List<DesignDto>

    @GET("ShowcaseDesign/{designId}")
    suspend fun getDesignById(
        @Path("designId") designId: String
    ): DesignDto
}