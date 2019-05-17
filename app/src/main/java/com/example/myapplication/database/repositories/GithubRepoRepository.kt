package com.example.myapplication.database.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.myapplication.database.daos.GithubRepoDAO
import com.example.myapplication.database.entities.GithubRepo

class GithubRepoRepository(private val repoDAO: GithubRepoDAO){

    fun obtenerTodo():LiveData<List<GithubRepo>> = repoDAO.obtenerTodos()

    fun borrarTodo() = repoDAO.borrarTodo()

    @WorkerThread
    suspend fun insert(repo:GithubRepo) = repoDAO.insert(repo)

}