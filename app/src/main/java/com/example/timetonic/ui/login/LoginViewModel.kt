package com.example.timetonic.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timetonic.data.repository.Repository
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val repository = Repository()

    fun authenticate(email: String, password: String, appKey: String, onSuccess: (String) -> Unit, onError: (String) -> Unit) {
        viewModelScope.launch {
            try {
                val oauthResponse = repository.createOauthkey("1.47", "createOauthkey", email, password, appKey)
                val sessResponse = repository.createSesskey("1.47", "createSesskey", "androiddeveloper", "androiddeveloper", oauthResponse.oauthkey)
                onSuccess(sessResponse.sesskey)
            } catch (e: Exception) {
                onError(e.message ?: "Unknown error")
            }
        }
    }
}