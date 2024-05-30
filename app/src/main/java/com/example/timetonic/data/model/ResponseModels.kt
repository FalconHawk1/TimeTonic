package com.example.timetonic.data.model

data class AuthResponse(
    val oauthkey: String
)

data class SesskeyResponse(
    val sesskey: String
)

data class BooksResponse(
    val books: List<Book>
)