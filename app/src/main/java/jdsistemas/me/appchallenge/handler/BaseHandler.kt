package jdsistemas.me.appchallenge.handler

import android.content.Context
import jdsistemas.me.appchallenge.R
import jdsistemas.me.appchallenge.data.datasource.ArticlesDataSourceImpl
import jdsistemas.me.appchallenge.data.remote.ArticlesApi
import jdsistemas.me.appchallenge.data.repository.ArticlesRepository
import jdsistemas.me.appchallenge.viewModel.ArticlesViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created on data 28/07/18.
 */
open class BaseHandler(var context: Context) {

    /**
     * Create view model.
     */
    fun createViewModel(): ArticlesViewModel {
        val retrofit = Retrofit.Builder().baseUrl(context.getString(R.string.url_base)).addConverterFactory(GsonConverterFactory.create()).build()
        val articlesDataSource = ArticlesDataSourceImpl(retrofit.create(ArticlesApi::class.java))
        val repository = ArticlesRepository(articlesDataSource)
        return ArticlesViewModel(repository, context)

    }

}