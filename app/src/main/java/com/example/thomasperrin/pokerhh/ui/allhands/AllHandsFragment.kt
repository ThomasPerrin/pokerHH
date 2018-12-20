package com.example.thomasperrin.pokerhh.ui.allhands

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thomasperrin.pokerhh.R
import com.example.thomasperrin.pokerhh.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_all_hands.*
import javax.inject.Inject

class AllHandsFragment: BaseFragment(), AllHandsInteractor{

    @Inject
    lateinit var mModel: AllHandsViewModel

    private var adapter = AllHandsAdapter(this)

    companion object{
        fun newInstance():AllHandsFragment{
            val args: Bundle = Bundle()
            val fragment = AllHandsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mModel.setInteractor(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mModel.hasChanged.observe(this, Observer {
            noItem.visibility = if(mModel.histories.isEmpty()) View.VISIBLE else View.GONE
            loading.visibility = View.GONE
            adapter.setData(mModel.histories)
        })
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        mModel.getAllHands()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView = inflater?.inflate(R.layout.fragment_all_hands, container, false)
        return rootView
    }

    override fun onPause() {
        super.onPause()
    }

    override fun loading() {
        loading.visibility = View.VISIBLE
    }



    override fun onDestroy() {
        super.onDestroy()
    }
}