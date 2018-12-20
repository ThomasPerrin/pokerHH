package com.example.thomasperrin.pokerhh.ui.newhand.newhand

import android.os.Bundle
import android.view.*
import com.example.thomasperrin.pokerhh.R
import com.example.thomasperrin.pokerhh.ui.BaseFragment
import com.example.thomasperrin.pokerhh.ui.newhand.flow.HistoryFlowFragment
import javax.inject.Inject

class NewHandFragment: BaseFragment(), NewHandInteractor {

    companion object{
        fun newInstance(): HistoryFlowFragment {
            val args: Bundle = Bundle()
            val fragment = HistoryFlowFragment()
            fragment.arguments = args
            return fragment
        }
    }

    @Inject
    lateinit var mModel: NewHandViewModel
    lateinit var rootView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mModel.setInteractor(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_new_hand, container, false)
        return rootView
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.next -> {

            }
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_new_hand, menu)
    }

}