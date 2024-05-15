package com.example.composeapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeapp.Data.Remote.RetrofitInstance
import com.example.composeapp.Data.model.Posts
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val api = RetrofitInstance.api
    private val _myStateFlow = MutableStateFlow<List<Posts>> (emptyList())
    val myStateFlow: StateFlow<List<Posts>> = _myStateFlow
    init {
        getPosts()
    }


    private fun getPosts() {
        viewModelScope.launch {
            val data = api.getPosts()
            if (data.isNotEmpty()) {
                _myStateFlow.value = data
            } else {
                _myStateFlow.value = emptyList()
            }
        }
    }
}