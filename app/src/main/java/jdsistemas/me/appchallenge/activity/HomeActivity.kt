package jdsistemas.me.appchallenge.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import jdsistemas.me.appchallenge.R
import jdsistemas.me.appchallenge.data.datasource.ArticlesDataSourceImpl
import jdsistemas.me.appchallenge.data.remote.ArticlesApi
import jdsistemas.me.appchallenge.data.repository.ArticlesRepository
import jdsistemas.me.appchallenge.fragment.DetailClientActivityFragment
import jdsistemas.me.appchallenge.viewModel.DetailClientViewModel
import kotlinx.android.synthetic.main.activity_home.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        card_view_clientes.setOnClickListener {

        }

        card_view_resumo_vendas.setOnClickListener {

        }

        card_view_ferramentas.setOnClickListener {

        }

        card_view_pedidos.setOnClickListener {

        }

    }

    /**
     * Create fragment in activity.
     *
     */
    private fun createFragment(): DetailClientActivityFragment {
//        return ArticlesFragment.newInstance(createViewModel())
        return DetailClientActivityFragment.newInstance(createViewModel())
    }


    /**
     * Create view model.
     */
//    fun createViewModel(): ArticlesViewModel {
//        val retrofit = Retrofit.Builder().baseUrl(getString(R.string.url_base)).addConverterFactory(GsonConverterFactory.create()).build()
//        val articlesDataSource = ArticlesDataSourceImpl(retrofit.create(ArticlesApi::class.java))
//        val repository = ArticlesRepository(articlesDataSource)
//        return ArticlesViewModel(repository, applicationContext)
//
//    }

    fun createViewModel(): DetailClientViewModel {
        val retrofit = Retrofit.Builder().baseUrl(getString(R.string.url_base)).addConverterFactory(GsonConverterFactory.create()).build()
        val articlesDataSource = ArticlesDataSourceImpl(retrofit.create(ArticlesApi::class.java))
        val repository = ArticlesRepository(articlesDataSource)
        return DetailClientViewModel(repository, applicationContext)

    }

}
