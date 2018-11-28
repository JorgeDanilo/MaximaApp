package jdsistemas.me.appchallenge.data.datasource

import jdsistemas.me.appchallenge.model.Data

interface ArticlesDataSource {

    fun listAll(success: (Data) -> Unit, failure: () -> Unit)

}
