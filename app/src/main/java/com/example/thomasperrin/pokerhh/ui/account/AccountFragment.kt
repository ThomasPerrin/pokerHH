package com.example.thomasperrin.pokerhh.ui.account

import android.os.Bundle
import com.example.thomasperrin.pokerhh.ui.BaseFragment

class AccountFragment: BaseFragment(), AccountInteractor {

    override fun saveHistory() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun back() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object{
        fun newInstance(): AccountFragment {
            val args: Bundle = Bundle()
            val fragment = AccountFragment()
            fragment.arguments = args
            return fragment
        }
    }


}