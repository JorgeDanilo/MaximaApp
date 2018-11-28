package jdsistemas.me.appchallenge.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import jdsistemas.me.appchallenge.adapter.ArticlesAdapter
import jdsistemas.me.appchallenge.databinding.FragmentArticlesBinding
import jdsistemas.me.appchallenge.viewModel.ArticlesViewModel


/**
 * A simple [Fragment] subclass.
 *
 */
class ArticlesFragment : Fragment() {

    /**
     * view Model.
     */
    lateinit var viewModel: ArticlesViewModel

    /**
     * Create new instance this fragment.
     */
    companion object {
        fun newInstance(viewModel: ArticlesViewModel): ArticlesFragment {
            val fragment = ArticlesFragment()
            fragment.viewModel = viewModel
            return fragment
        }
    }


    /**
     * On start and load data from api.
     */
    override fun onStart() {
        super.onStart()
        viewModel.load()
    }


    /**
     * Create view.
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentArticlesBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.recyclerView.adapter = ArticlesAdapter(emptyList(), context!!.applicationContext)
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        return binding.root
    }

}
