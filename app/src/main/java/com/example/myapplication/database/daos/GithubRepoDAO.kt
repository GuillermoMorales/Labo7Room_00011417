package com.example.myapplication.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.database.entities.GithubRepo

@Dao
interface GithubRepoDAO {
    @Query("SELECT * from  repos")
    fun obtenerTodos():LiveData<List<GithubRepo>>

    @Query("DELETE FROM repos")
    fun borrarTodo()

    @Insert(onConflict = OnConflictStrategy.REPLACE)//INSERT Y UN UPDATE
    suspend fun insert(repo:GithubRepo)
}