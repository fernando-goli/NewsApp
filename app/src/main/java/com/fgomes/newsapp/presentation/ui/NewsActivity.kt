package com.fgomes.newsapp.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.fgomes.newsapp.R
import com.fgomes.newsapp.data.local.ArticleDatabase
import com.fgomes.newsapp.data.repository.NewsRepositoryImpl
import com.fgomes.newsapp.presentation.viewmodel.NewsViewModel
import com.fgomes.newsapp.presentation.viewmodel.NewsViewModelProviderFactory
import com.google.android.material.bottomnavigation.BottomNavigationView

class NewsActivity : AppCompatActivity() {

    //private lateinit var navController: NavController
    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_news)

        val newsRepository = NewsRepositoryImpl(ArticleDatabase(this), RetrofitInstance.api )
        val viewModelProviderFactory = NewsViewModelProviderFactory(application, newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)
        //bottomNavigationView.setupWithNavController(newsNavHostFragment.findNavController())

        /*val nav: BottomNavigationView = binding.bottomNavigationView
        val navController = findNavController(R.id.newsNavHostFragment)
        nav.setupWithNavController(navController)*/

       /* val navHostFragment = supportFragmentManager.findFragmentById(R.id.newsNavHostFragment) as NavHostFragment
        navController = navHostFragment.navController*/

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.newsNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        findViewById<BottomNavigationView>(R.id.bottomNavigationView)
            .setupWithNavController(navController)
    }

    // Using onPostCreate because accessing NavHost in OnCreate causes crashe
   /* override fun onPostCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onPostCreate(savedInstanceState, persistentState)
        binding.bottomNavigationView.setupWithNavController(findNavController(R.id.newsNavHostFragment))
        NavigationUI.setupWithNavController(
            binding.bottomNavigationView,
            findNavController(R.id.newsNavHostFragment)
        )
    }*/
}