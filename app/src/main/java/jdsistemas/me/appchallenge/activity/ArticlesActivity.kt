package jdsistemas.me.appchallenge.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import jdsistemas.me.appchallenge.R
import jdsistemas.me.appchallenge.data.datasource.ArticlesDataSourceImpl
import jdsistemas.me.appchallenge.data.remote.ArticlesApi
import jdsistemas.me.appchallenge.data.repository.ArticlesRepository
import jdsistemas.me.appchallenge.fragment.ArticlesFragment
import jdsistemas.me.appchallenge.viewModel.ArticlesViewModel
import kotlinx.android.synthetic.main.activity_articles.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ArticlesActivity : BaseActivity() {


    /**
     * On create activity.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles)
        addFragmentTo(R.id.content_frame, createFragment())
        setSupportActionBar(toolbar)

    }

    /**
     * Create fragment in activity.
     *
     */
    private fun createFragment(): Fragment {
        return ArticlesFragment.newInstance(createViewModel())
    }


    /**
     * Create view model.
     */
    fun createViewModel(): ArticlesViewModel {
        val retrofit = Retrofit.Builder().baseUrl(getString(R.string.url_base)).addConverterFactory(GsonConverterFactory.create()).build()
        val articlesDataSource = ArticlesDataSourceImpl(retrofit.create(ArticlesApi::class.java))
        val repository = ArticlesRepository(articlesDataSource)
        return ArticlesViewModel(repository, applicationContext)

    }



}
