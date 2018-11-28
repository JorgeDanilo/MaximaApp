package jdsistemas.me.appchallenge.data.repository

import jdsistemas.me.appchallenge.data.datasource.ArticlesDataSource
import jdsistemas.me.appchallenge.model.Data

/**
 * Created on data 27/07/18.
 */
class ArticlesRepository(private val articlesDataSource: ArticlesDataSource): ArticlesDataSource {

    override fun listAll(success: (Data) -> Unit, failure: () -> Unit) {
        articlesDataSource.listAll(success, failure)
    }

}