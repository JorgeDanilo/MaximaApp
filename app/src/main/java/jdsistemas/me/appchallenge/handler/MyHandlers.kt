package jdsistemas.me.appchallenge.handler

import android.content.Context
import android.content.Intent
import jdsistemas.me.appchallenge.activity.DetailArticleActivity
import jdsistemas.me.appchallenge.model.Article

/**
 * @author Jorge Danilo Gomes.
 *
 * Class event handler for the article.
 */
open class MyHandlers(private val context: Context){


    /**
     * @author Jorge Danilo Gomes.
     * Action responsible for show detail.
     *
     */
    fun toDetail(article: Article) {
        val intent = Intent(context, DetailArticleActivity::class.java)
        intent.putExtra("article", article)
        context.startActivity(intent)
        article.isRead = true
        BaseHandler(context).createViewModel().refreshModel(article)
    }

    /**
     * @author Jorge Danilo Gomes.
     * Action responsible for marking an article as read.
     *
     */
    fun markRead(article: Article) {
        article.isRead = false
        BaseHandler(context).createViewModel().refreshModel(article)
    }

}