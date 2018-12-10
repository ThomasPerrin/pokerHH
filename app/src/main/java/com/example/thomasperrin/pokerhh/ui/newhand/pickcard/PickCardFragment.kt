package com.example.thomasperrin.pokerhh.ui.newhand.pickcard

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.thomasperrin.pokerhh.R
import com.example.thomasperrin.pokerhh.ui.BaseFragment
import com.example.thomasperrin.pokerhh.ui.newhand.NewHandActivity
import kotlinx.android.synthetic.main.fragment_pick_card.*
import javax.inject.Inject

class PickCardFragment: BaseFragment(), PickCardInteractor {

    companion object{
        fun newInstance(): PickCardFragment {
            val args: Bundle = Bundle()
            val fragment = PickCardFragment()
            fragment.arguments = args
            return fragment
        }
    }

    @Inject
    lateinit var mModel: PickCardViewModel

    lateinit var rootView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mModel.setInteractor(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_pick_card, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (activity as NewHandActivity).mModel.history.board = mModel.getHistoryBoard()

        heart.setOnClickListener { mModel.setColorSelected(it.id) }
        spade.setOnClickListener { mModel.setColorSelected(it.id) }
        clover.setOnClickListener { mModel.setColorSelected(it.id) }
        diamond.setOnClickListener { mModel.setColorSelected(it.id) }

        two.setOnClickListener { mModel.setCardSelected(it.tag as Int) }
        three.setOnClickListener { mModel.setCardSelected(it.tag as Int) }
        four.setOnClickListener { mModel.setCardSelected(it.tag as Int) }
        five.setOnClickListener { mModel.setCardSelected(it.tag as Int) }
        six.setOnClickListener { mModel.setCardSelected(it.tag as Int) }
        seven.setOnClickListener { mModel.setCardSelected(it.tag as Int) }
        height.setOnClickListener { mModel.setCardSelected(it.tag as Int) }
        nine.setOnClickListener { mModel.setCardSelected(it.tag as Int) }
        ten.setOnClickListener { mModel.setCardSelected(it.tag as Int) }
        jack.setOnClickListener { mModel.setCardSelected(it.tag as Int) }
        queen.setOnClickListener { mModel.setCardSelected(it.tag as Int) }
        king.setOnClickListener { mModel.setCardSelected(it.tag as Int) }
        aces.setOnClickListener { mModel.setCardSelected(it.tag as Int) }

        previous.setOnClickListener {
            if(gridCard.visibility == View.VISIBLE){
                gridColor.visibility = View.VISIBLE
                gridCard.visibility = View.GONE
            } else
                mModel.previousClick()
        }
        finish.setOnClickListener { mModel.validate() }

        container.setOnClickListener { onBack() }

    }

    override fun validate() {
        (activity!! as NewHandActivity).mModel.history.board = mModel.getHistoryBoard()
        onBack()
    }

    override fun onColorSelected() {
        Log.e("HERE","SETIMAGES")
        two.setImageResource(mModel.cardsDisplaying[0])
        three.setImageResource(mModel.cardsDisplaying[1])
        four.setImageResource(mModel.cardsDisplaying[2])
        five.setImageResource(mModel.cardsDisplaying[3])
        six.setImageResource(mModel.cardsDisplaying[4])
        seven.setImageResource(mModel.cardsDisplaying[5])
        height.setImageResource(mModel.cardsDisplaying[6])
        nine.setImageResource(mModel.cardsDisplaying[7])
        ten.setImageResource(mModel.cardsDisplaying[8])
        jack.setImageResource(mModel.cardsDisplaying[9])
        queen.setImageResource(mModel.cardsDisplaying[10])
        king.setImageResource(mModel.cardsDisplaying[11])
        aces.setImageResource(mModel.cardsDisplaying[12])
        
        two.tag = (mModel.cardsDisplaying[0])
        three.tag = mModel.cardsDisplaying[1]
        four.tag = mModel.cardsDisplaying[2]
        five.tag = mModel.cardsDisplaying[3]
        six.tag = mModel.cardsDisplaying[4]
        seven.tag = mModel.cardsDisplaying[5]
        height.tag = mModel.cardsDisplaying[6]
        nine.tag = mModel.cardsDisplaying[7]
        ten.tag = mModel.cardsDisplaying[8]
        jack.tag = mModel.cardsDisplaying[9]
        queen.tag = mModel.cardsDisplaying[10]
        king.tag = mModel.cardsDisplaying[11]
        aces.tag = mModel.cardsDisplaying[12]

        gridColor.visibility = View.GONE
        gridCard.visibility = View.VISIBLE
    }

    override fun onCardSelected() {
        when(mModel.cards.size){
            1 -> card1.setImageResource(mModel.cardDisplaying)
            2 -> card2.setImageResource(mModel.cardDisplaying)
            3 -> card3.setImageResource(mModel.cardDisplaying)
            4 -> card4.setImageResource(mModel.cardDisplaying)
            5 -> card5.setImageResource(mModel.cardDisplaying)
        }
        gridColor.visibility = View.VISIBLE
        gridCard.visibility = View.GONE
    }

    override fun onBack() {
        (activity!! as NewHandActivity).supportFragmentManager.popBackStack()
    }

    override fun onCardRemove() {
        when(mModel.cards.size){
            0 -> card1.setImageResource(R.drawable.blue_back)
            1 -> card2.setImageResource(R.drawable.blue_back)
            2 -> card3.setImageResource(R.drawable.blue_back)
            3 -> card4.setImageResource(R.drawable.blue_back)
            4 -> card5.setImageResource(R.drawable.blue_back)
        }
    }
}