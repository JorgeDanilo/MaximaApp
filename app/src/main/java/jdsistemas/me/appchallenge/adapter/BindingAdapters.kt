package jdsistemas.me.appchallenge.adapter

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView

/**
 * Created on data 27/07/18.
 */
class BindingAdapters {

    companion object {
        @BindingAdapter("items")
        @JvmStatic
        fun setItems(recyclerView: RecyclerView, items: List<Any>) {
            recyclerView.adapter.let {
                if (it is AdapterItemContract) {
                    it.replaceItems(items)
                }
            }
        }
    }

}