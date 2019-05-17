package com.example.myapplication.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R
import com.example.myapplication.database.entities.GithubRepo
import com.example.myapplication.viewmodels.GithubRepoViewModel

class MainActivity : AppCompatActivity() {

    lateinit var viewModel:GithubRepoViewModel
    var contador: Int = 0
    lateinit var btnAction:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnAction = findViewById(R.id.btn_action)
    }

    private fun bind()
    {
        viewModel = ViewModelProviders.of(this@MainActivity).get(GithubRepoViewModel::class.java)
        viewModel.getRepoList().observe(this, Observer{

        })
        btnAction.setOnclickListener
        {
            viewModel.insert(GithubRepo("Repositorio #$contador"))
            contador++
        }

    }
}
