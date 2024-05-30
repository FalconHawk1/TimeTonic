package com.example.timetonic.ui.book

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timetonic.data.model.Book
import com.example.timetonic.data.repository.Repository
import kotlinx.coroutines.launch

class BookViewModel : ViewModel() {

    private val repository = Repository()

    private val _books = MutableLiveData<List<Book>>()
    val books: LiveData<List<Book>> = _books

    fun fetchBooks(sesskey: String) {
        viewModelScope.launch {
            try {
                val booksResponse = repository.getAllBooks("1.47", "getAllBooks", "androiddeveloper", "androiddeveloper", sesskey)
                _books.value = booksResponse.books.filter { it.ownerPrefs.oCoverImg.isNotEmpty() }
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}