package com.example.myapplication.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.database.RoomDatabase
import com.example.myapplication.database.entities.GithubRepo
import com.example.myapplication.database.repositories.GithubRepoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GithubRepoViewModel(app: Application):AndroidViewModel(app) {
    private val repository: GithubRepoRepository

    init {
        val repoDAO = RoomDatabase.getInstance(app).repoDAO()
        repository = GithubRepoRepository(repoDAO)
    }

    fun getRepoList():LiveData<List<GithubRepoRepository>> = repository.obtenerTodo()
    fun insert(repo:GithubRepo) = viewModelScope.launch(Dispatchers.IO) {

    }
}