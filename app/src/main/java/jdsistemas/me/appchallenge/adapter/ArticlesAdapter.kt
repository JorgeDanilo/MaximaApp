package jdsistemas.me.appchallenge.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import jdsistemas.me.appchallenge.databinding.ArticleItemBinding
import jdsistemas.me.appchallenge.handler.MyHandlers
import jdsistemas.me.appchallenge.model.Article

/**
 * Created on data 27/07/18.
 */
class ArticlesAdapter(var items: List<Article>, var context: Context): RecyclerView.Adapter<ArticlesAdapter.ViewHolder>(), AdapterItemContract {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ArticleItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun replaceItems(items: List<*>) {
        this.items = items as List<Article>
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ViewHolder(val binding: ArticleItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(articles: Article) {
            binding.article = articles
            binding.executePendingBindings()
            binding.handlers = MyHandlers(context)
        }
    }
}