package com.example.myapplication.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.database.entities.GitHubRepo

@Dao
interface GitHubRepoDAO {


    @Query( "SELECT * FROM repos")
    fun getAll():LiveData<List<GitHubRepo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(repo:GitHubRepo)

    @Query("DELETE FROM repos")
    fun nukeTable()

}