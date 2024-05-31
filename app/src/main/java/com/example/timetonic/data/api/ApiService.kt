package com.example.timetonic.data.api

import com.example.timetonic.data.model.AppkeyResponse
import com.example.timetonic.data.model.AuthResponse
import com.example.timetonic.data.model.BooksResponse
import com.example.timetonic.data.model.SesskeyResponse
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Field
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("api.php")
    suspend fun createAppKey(
        @Field("version") version: String,
        @Field("req") req: String,
        @Field("appname") appname: String
    ): AppkeyResponse

    @FormUrlEncoded
    @POST("api.php")
    suspend fun createOauthkey(
        @Field("version") version: String,
        @Field("req") req: String,
        @Field("login") login: String,
        @Field("pwd") pwd: String,
        @Field("appkey") appkey: String
    ): AuthResponse

    @FormUrlEncoded
    @POST("api.php")
    suspend fun createSesskey(
        @Field("version") version: String,
        @Field("req") req: String,
        @Field("o_u") ou: String,
        @Field("u_c") uc: String,
        @Field("oauthkey") oauthkey: String
    ): SesskeyResponse

    @FormUrlEncoded
    @POST("api.php")
    suspend fun getAllBooks(
        @Field("version") version: String,
        @Field("req") req: String,
        @Field("u_c") uc: String,
        @Field("o_u") ou: String,
        @Field("sesskey") sesskey: String
    ): BooksResponse
}
