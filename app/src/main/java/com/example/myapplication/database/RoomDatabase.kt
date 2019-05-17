package com.example.myapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.database.daos.GithubRepoDAO
import com.example.myapplication.database.entities.GithubRepo

@Database(entities = [GithubRepo::class],version = 1,exportSchema = false)
public abstract class RoomDatabase:RoomDatabase() {

    abstract fun repoDAO():GithubRepoDAO
    companion object {
        @Volatile
        private var INSTANCE:RoomDatabase? = null

        fun getInstance(context:Context):RoomDatabase {
            val temp = INSTANCE

            if(temp != null)
            {
                return temp
            }
            synchronized(this)
            {
                val instance = Room.databaseBuilder(context,RoomDatabase::class.java,"RepoDB").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}