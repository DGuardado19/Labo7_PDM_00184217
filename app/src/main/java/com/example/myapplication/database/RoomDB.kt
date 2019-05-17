package com.example.myapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.database.daos.GitHubRepoDAO
import com.example.myapplication.database.entities.GitHubRepo

@Database(entities = [GitHubRepo::class], version = 1, exportSchema = false)
public abstract class RoomDB:RoomDatabase(){

    abstract  fun  repoDAO():GitHubRepoDAO


    companion object {
        @Volatile
        private var INSTANCE:RoomDB?= null

        fun getInstance(
            context: Context
        ):RoomDB{
            val tempInstance = INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context, RoomDB::class.java, "Repo_DB").build()
                INSTANCE=instance
                return  instance
            }
        }
    }

}