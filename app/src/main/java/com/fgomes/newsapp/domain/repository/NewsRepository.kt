package com.fgomes.newsapp.domain.repository

import androidx.lifecycle.LiveData
import com.fgomes.newsapp.data.models.Article
import com.fgomes.newsapp.data.models.NewsResponse
import retrofit2.Response

interface NewsRepository {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int): Response<NewsResponse>

    suspend fun searchNews(searchQuery: String, pageNumber: Int): Response<NewsResponse>

    suspend fun upsert(article: Article): Long

    fun getSavedNews(): LiveData<List<Article>>

    suspend fun deleteArticle(article: Article)
}