package com.example.thomasperrin.pokerhh.ui.newhand

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.list.checkItem
import com.afollestad.materialdialogs.list.listItemsSingleChoice
import com.example.thomasperrin.pokerhh.R
import com.example.thomasperrin.pokerhh.ui.BaseActivity
import com.example.thomasperrin.pokerhh.ui.newhand.flow.HistoryFlowFragment
import com.example.thomasperrin.pokerhh.ui.newhand.pickcard.PickCardFragment
import com.example.thomasperrin.pokerhh.utils.HelperHistory
import kotlinx.android.synthetic.main.activity_new_hand.*
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
            if(pickCardFragment == null)
                pickCardFragment = PickCardFragment.newInstance()
            replaceFrag(pickCardFragment!!)
        }

        typeContainer.setOnClickListener{
            val myItems = listOf("MTT", "Cash Game", "Satellite", "Sit N Go", "Expresso")
            dialog = MaterialDialog(this).show {
                listItemsSingleChoice(items = myItems) { dialog, index, text ->
                    dialog.checkItem(index)
                }
                positiveButton(R.string.validate)
            }
        }

        blindes.addTextChangedListener(textChangeListener("bb"))
        type_text.addTextChangedListener(textChangeListener("type"))
        ante.addTextChangedListener(textChangeListener("ante"))
        numberPlayer.addTextChangedListener(textChangeListener("nbPlayers"))
        description.addTextChangedListener(textChangeListener("description"))
        keywords.addTextChangedListener(textChangeListener("keywords"))

        action.isEnabled = mModel.canGoAction.value ?: false
        mModel.canGoAction.observe(this, Observer {
            action.isEnabled = it
        })

        mModel.board.observe(this, Observer {
            val array = HelperHistory.getImageHand(it)
            if(array.size == 3){
                board.card1.setImageResource(array[0])
                board.card2.setImageResource(array[1])
                board.card3.setImageResource(array[2])
            }
            if(array.size > 3)
                board.card4.setImageResource(array[3])
            if(array.size > 4)
                board.card5.setImageResource(array[4])
        })

    }

    private fun textChangeListener(type: String):TextWatcher{
        return object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                mModel.setValues(p0.toString(), type)
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //NOT USE
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //NOT USE
            }
        }
    }

    private fun replaceFrag(fragment: Fragment){
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer,fragment,fragment.toString()).addToBackStack(fragment.toString()).commit()
    }

    override fun onResume() {
        super.onResume()
        mModel.setInteractor(this)
        Log.e("onPostResume","onPostResume")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.validate -> {
                mModel.registerHH()
            }
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_pick_card, menu)
        return true
    }

    override fun validate() {
        onBackPressed()
    }
}