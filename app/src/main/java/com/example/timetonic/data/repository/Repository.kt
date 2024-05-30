package com.example.timetonic.data.repository

import com.example.timetonic.data.api.ApiClient
import com.example.timetonic.data.model.AuthResponse
import com.example.timetonic.data.model.BooksResponse
import com.example.timetonic.data.model.SesskeyResponse

class Repository {

    private val apiService = ApiClient.apiService

    suspend fun createOauthkey(version: String, req: String, login: String, pwd: String, appkey: String): AuthResponse {
        return apiService.createOauthkey(version, req, login, pwd, appkey)
    }

    suspend fun createSesskey(version: String, req: String, ou: String, uc: String, oauthkey: String): SesskeyResponse {
        return apiService.createSesskey(version, req, ou, uc, oauthkey)
    }

    suspend fun getAllBooks(version: String, req: String, uc: String, ou: String, sesskey: String): BooksResponse {
        return apiService.getAllBooks(version, req, uc, ou, sesskey)
    }
}