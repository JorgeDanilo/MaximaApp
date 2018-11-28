package jdsistemas.me.appchallenge.data.datasource

import jdsistemas.me.appchallenge.data.remote.ArticlesApi
import jdsistemas.me.appchallenge.model.Data
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArticlesDataSourceImpl(private val articlesApi: ArticlesApi): ArticlesDataSource {


    /**
     * List all articles on api.
     *
     */
    override fun listAll(success: (Data) -> Unit, failure: () -> Unit) {

        val call = articlesApi.listArticles()
        call.enqueue(object : Callback<Data> {

            /**
             * On response api.
             *
             */
            override fun onResponse(call: Call<Data>?, response: Response<Data>) {
                when {
                    response.isSuccessful -> {
                       success(response.body()!!)
                    }
                    else -> failure()
                }
            }

            /**
             *  On failure request.
             *
             */
            override fun onFailure(call: Call<Data>?, t: Throwable?) {
                failure()
            }
        })
    }


}
