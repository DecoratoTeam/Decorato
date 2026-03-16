package com.example.decorato.data.repositoryImpl

import com.example.decorato.data.mapper.DesignMapper
import com.example.decorato.data.remote.api.DesignApiService
import com.example.decorato.domain.entity.Design
import com.example.decorato.domain.entity.RecentlyWatchedDesign
import com.example.decorato.domain.exceptions.NoInternetException
import com.example.decorato.domain.exceptions.ServerErrorException
import com.example.decorato.domain.exceptions.UnknownException
import com.example.decorato.domain.repository.DesignRepository
import com.example.decorato.domain.entity.RoomDesign
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class DesignRepositoryImpl @Inject constructor(
    private val designApiService: DesignApiService,
    private val designMapper: DesignMapper
) : DesignRepository {

    override suspend fun getPopularDesigns(): List<Design> {
        return try {
            val response = designApiService.getPopularDesigns()
            response.map { designMapper.mapToDesign(it) }
        } catch (e: IOException) {
            throw NoInternetException()
        } catch (e: HttpException) {
            when (e.code()) {
                in 500..599 -> throw ServerErrorException()
                else -> throw UnknownException()
            }
        } catch (e: Exception) {
            throw UnknownException()
        }
    }

    override suspend fun getRecentlyWatchedDesigns(): List<RecentlyWatchedDesign> {
        return try {
            val response = designApiService.getRecentlyWatchedDesigns()
            response.map { designMapper.mapToRecentlyWatchedDesign(it) }
        } catch (e: IOException) {
            throw NoInternetException()
        } catch (e: HttpException) {
            when (e.code()) {
                in 500..599 -> throw ServerErrorException()
                else -> throw UnknownException()
            }
        } catch (e: Exception) {
            throw UnknownException()
        }
    }

    override suspend fun getDesignsByStyle(styleId: String): List<RoomDesign> {
        return try {
            val response = designApiService.getDesignsByStyle(styleId)
            response.map { designMapper.mapToRoomDesign(it) }
        } catch (e: IOException) {
            throw NoInternetException()
        } catch (e: HttpException) {
            when (e.code()) {
                in 500..599 -> throw ServerErrorException()
                else -> throw UnknownException()
            }
        } catch (e: Exception) {
            throw UnknownException()
        }
    }

    override suspend fun getDesignById(designId: String): Design {
        return try {
            val response = designApiService.getDesignById(designId)
            designMapper.mapToDesign(response)
        } catch (e: IOException) {
            throw NoInternetException()
        } catch (e: HttpException) {
            when (e.code()) {
                in 500..599 -> throw ServerErrorException()
                else -> throw UnknownException()
            }
        } catch (e: Exception) {
            throw UnknownException()
        }
    }
}