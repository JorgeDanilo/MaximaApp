package jdsistemas.me.appchallenge.fragment

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import jdsistemas.me.appchallenge.R
import jdsistemas.me.appchallenge.viewModel.DetailClientViewModel

/**
 * A placeholder fragment containing a simple view.
 */
class DetailClientActivityFragment : Fragment() {


    lateinit var viewModel: DetailClientViewModel

    companion object {
        fun newInstance(viewModel: DetailClientViewModel): DetailClientActivityFragment {
            val fragment = DetailClientActivityFragment()
            fragment.viewModel = viewModel
            return fragment
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.load()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        val inflate = inflater.inflate(R.layout.fragment_detail_client, container, false)

        return inflate;

    }
}
