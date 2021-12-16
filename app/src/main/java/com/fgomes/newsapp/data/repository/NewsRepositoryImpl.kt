package com.fgomes.newsapp.data.repository

import androidx.lifecycle.LiveData
import com.fgomes.newsapp.data.local.ArticleDatabase
import com.fgomes.newsapp.data.models.Article
import com.fgomes.newsapp.data.models.NewsResponse
import com.fgomes.newsapp.data.remote.NewsApi
import com.fgomes.newsapp.domain.repository.NewsRepository
import retrofit2.Response

class NewsRepositoryImpl (
    db: ArticleDatabase,
    val serviceApi: NewsApi
    ) : NewsRepository{

    private val getArticleDao = db.getArticleDao()

    //api
    override suspend fun getBreakingNews(countryCode: String, pageNumber: Int): Response<NewsResponse> {
        //return RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)
        return serviceApi.getBreakingNews(countryCode, pageNumber)
    }

    override suspend fun searchNews(searchQuery: String, pageNumber: Int): Response<NewsResponse> {
       // return RetrofitInstance.api.searchForNews(searchQuery, pageNumber)
        return serviceApi.searchForNews(searchQuery, pageNumber)
    }

    //db
    override suspend fun upsert(article: Article): Long {
       return getArticleDao.upsert(article)
    }

    override fun getSavedNews(): LiveData<List<Article>> {
         return getArticleDao.getAllArticles()
    }

    override suspend fun deleteArticle(article: Article) {
        getArticleDao.deleteArticle(article)
    }

}