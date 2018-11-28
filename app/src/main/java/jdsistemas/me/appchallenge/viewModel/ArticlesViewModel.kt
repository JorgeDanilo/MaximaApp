package jdsistemas.me.appchallenge.viewModel

import android.content.Context
import android.databinding.ObservableArrayList
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import jdsistemas.me.appchallenge.R
import jdsistemas.me.appchallenge.data.repository.ArticlesRepository
import jdsistemas.me.appchallenge.handler.MyHandlers
import jdsistemas.me.appchallenge.model.Article
import jdsistemas.me.appchallenge.utils.NetworkUtil
import android.content.Intent
import android.content.BroadcastReceiver
import android.util.Log
import android.net.ConnectivityManager
import android.content.IntentFilter
import android.widget.Toast


/**
 * @author Jorge Danilo Gomes.
 *
 * Class responsible for the view of the article view.
 *
 */
class ArticlesViewModel(private val repository: ArticlesRepository, val context: Context) : MyHandlers(context) {

    companion object {

        /**
         * Observable binding articles. (simulating a database).
         */
        @JvmStatic
        val articles = ObservableArrayList<Article>()
    }


    /**
     * Loading observable.
     */
    val loadingVisibility = ObservableBoolean(false)


    /**
     * Atribute message.
     *
     */
    val message = ObservableField<String>()


    /**
     *  Load article in api and change views.
     */
    fun load() {
        loadingVisibility.set(true)
        message.set("")
        checkNetwork()
        if (articles.isEmpty()) {
            repository.listAll({ items ->
                articles.clear()
//                articles.addAll(items.data)
                articles.sortBy { it.title }
                if (items.data.isEmpty()) {
                    message.set(context.getString(R.string.msg_not_found))
                }
                loadingVisibility.set(false)
            }, {
                message.set(context.getString(R.string.msg_failure))
                loadingVisibility.set(false)
            })
        }
    }


    fun checkNetwork() {
        val intentFilter = IntentFilter()
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION)
        context.registerReceiver(networkChangeReceiver, intentFilter)
    }

    private val networkChangeReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val status = NetworkUtil().getConnectivityStatus(context)
            if (status == NetworkUtil().NETWORK_STATUS_NOT_CONNECTED) {
                Toast.makeText(context, context.getString(R.string.msg_failure), Toast.LENGTH_SHORT).show()
                loadingVisibility.set(false)
            } else {
                load()
            }
        }
    }

    /**
     * Responsible for updating the model
     *
     */
    fun refreshModel(article: Article) {
        ArticlesViewModel.articles.remove(article)
        ArticlesViewModel.articles.add(0, article)
        ArticlesViewModel.articles.sortBy { it.title }
    }

}
