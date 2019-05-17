package com.example.myapplication.database.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.myapplication.database.daos.GitHubRepoDAO
import com.example.myapplication.database.entities.GitHubRepo

class GitHubRepoRepository(private val repoDAO: GitHubRepoDAO) {


    fun getAll(): LiveData<List<GitHubRepo>> = repoDAO.getAll()

    fun nuke() = repoDAO.nukeTable()

    @WorkerThread
    suspend fun insert(repo: GitHubRepo) =  repoDAO.insert(repo)

}