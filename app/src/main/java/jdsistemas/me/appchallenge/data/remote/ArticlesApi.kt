package jdsistemas.me.appchallenge.data.remote

import jdsistemas.me.appchallenge.model.Data
import retrofit2.Call
import retrofit2.http.GET

interface ArticlesApi {

    /**
     * Find articles on api from json.
     */
    @GET("files/articles.json")
    fun listArticles(): Call<Data>

}