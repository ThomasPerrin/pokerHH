package com.example.thomasperrin.pokerhh.ui.newhand

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.list.checkItem
import com.afollestad.materialdialogs.list.listItemsSingleChoice
import com.example.thomasperrin.pokerhh.R
import com.example.thomasperrin.pokerhh.ui.BaseActivity
import com.example.thomasperrin.pokerhh.ui.newhand.flow.HistoryFlowFragment
import com.example.thomasperrin.pokerhh.ui.newhand.pickcard.PickCardFragment
import kotlinx.android.synthetic.main.activity_new_hand.*
import studio.carbonylgroup.textfieldboxes.ExtendedEditText
import javax.inject.Inject


class NewHandActivity: BaseActivity(), NewHandInteractor {

    @Inject
    lateinit var mModel: NewHandViewModel

    private var historyFlowFragment: HistoryFlowFragment? = null
    private var pickCardFragment: PickCardFragment? = null

    private var dialog: MaterialDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_hand)

        action.setOnClickListener {
            if(historyFlowFragment == null)
                historyFlowFragment = HistoryFlowFragment.newInstance()
            replaceFrag(historyFlowFragment!!)
        }

        board.setOnClickListener {
            if(historyFlowFragment == null)
                pickCardFragment = PickCardFragment.newInstance()
            replaceFrag(pickCardFragment!!)
        }

        typeContainer.setOnClickListener{
            val myItems = listOf("MTT", "Cash Game", "Satellite", "Sit N Go", "Expresso")
            dialog = MaterialDialog(this).show {
                listItemsSingleChoice(items = myItems) { dialog, index, text ->
                    Log.e("text","${this.type_text}")
                    findViewById<ExtendedEditText>(R.id.type_text).setText(text)
                    dialog.checkItem(index)
                }
                positiveButton(R.string.validate)
            }
        }
    }

    private fun replaceFrag(fragment: Fragment){
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer,fragment,fragment.toString()).commit()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}