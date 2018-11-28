package jdsistemas.me.appchallenge.activity

import android.os.Bundle
import jdsistemas.me.appchallenge.R
import jdsistemas.me.appchallenge.utils.loadImage
import jdsistemas.me.appchallenge.model.Article
import kotlinx.android.synthetic.main.activity_detail.*

class DetailArticleActivity : BaseActivity() {

    lateinit var article: Article

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        article = intent.extras!!.getSerializable("article") as Article

        loadImage(image, article.image_url)
        txtTitle.text = article.title
        txtWebSite.text = article.website
        txtContent.text = article.content
        txtDate.text = article.date
    }
}
