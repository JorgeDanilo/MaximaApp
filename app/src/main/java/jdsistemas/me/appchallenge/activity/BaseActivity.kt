package jdsistemas.me.appchallenge.activity

import android.support.v7.app.AppCompatActivity
import jdsistemas.me.appchallenge.R
import jdsistemas.me.appchallenge.data.datasource.ArticlesDataSourceImpl
import jdsistemas.me.appchallenge.data.remote.ArticlesApi
import jdsistemas.me.appchallenge.data.repository.ArticlesRepository
import jdsistemas.me.appchallenge.viewModel.ArticlesViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Create view Model and
 */
open class BaseActivity: AppCompatActivity()