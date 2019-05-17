package com.example.myapplication.database.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.database.RoomDB
import com.example.myapplication.database.entities.GitHubRepo
import com.example.myapplication.database.repositories.GitHubRepoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GitHubViewModel(app:Application):AndroidViewModel(app){

    private val repository:GitHubRepoRepository

    init {
        val repoDao = RoomDB.getInstance(app).repoDAO()
        repository=GitHubRepoRepository(repoDao)
    }

    fun getAll():LiveData<List<GitHubRepo>> = repository.getAll()

    fun insert(repo: GitHubRepo) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(repo)
    }



}