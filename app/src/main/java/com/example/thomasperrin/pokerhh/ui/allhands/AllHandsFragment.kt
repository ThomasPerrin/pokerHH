package com.example.thomasperrin.pokerhh.ui.allhands

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.thomasperrin.pokerhh.R
import com.example.thomasperrin.pokerhh.ui.BaseFragment

class AllHandsFragment: BaseFragment(){

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
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView = inflater?.inflate(R.layout.fragment_all_hands, container, false)
        return rootView
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}