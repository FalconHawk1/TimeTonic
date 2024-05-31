package com.example.timetonic.data.model

data class AppkeyResponse(
    val appKey: String
)
data class AuthResponse(
    val oauthkey: String
)

data class SesskeyResponse(
    val sesskey: String
)

data class BooksResponse(
    val books: List<Book>
)