package com.example.timetonic.data.model

data class Book(
    val id: String,
    val name: String,
    val ownerPrefs: OwnerPrefs
)

data class OwnerPrefs(
    val oCoverImg: String
)