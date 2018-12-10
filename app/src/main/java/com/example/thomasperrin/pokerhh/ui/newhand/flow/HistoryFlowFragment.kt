package com.example.thomasperrin.pokerhh.ui.newhand.flow

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.thomasperrin.pokerhh.R
import com.example.thomasperrin.pokerhh.ui.BaseFragment
import com.example.thomasperrin.pokerhh.ui.newhand.NewHandActivity
import com.example.thomasperrin.pokerhh.utils.HelperHistory
import kotlinx.android.synthetic.main.fragment_flow.*
import javax.inject.Inject

class HistoryFlowFragment: BaseFragment(), HistoryFlowInteractor {

    companion object{
        fun newInstance(): HistoryFlowFragment {
            val args: Bundle = Bundle()
            val fragment = HistoryFlowFragment()
            fragment.arguments = args
            return fragment
        }
    }

    @Inject
    lateinit var mModel: HistoryFlowViewModel
    lateinit var rootView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mModel.setInteractor(this)

        (activity as NewHandActivity).mModel.history.nbPlayers = 9
        (activity as NewHandActivity).mModel.history.bigBlind = 150

        ((activity as NewHandActivity).mModel.history).board = "s2|s3|s10|ha|dk"
        mModel.history = ((activity as NewHandActivity).mModel.history)
        mModel.nbPlayer = ((activity as NewHandActivity).mModel.history.nbPlayers)
        mModel.priceMin = ((activity as NewHandActivity).mModel.history.bigBlind)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_flow, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fold.setOnClickListener {
            mModel.nextPlayer("fold")
        }
        action.setOnClickListener {
            mModel.nextPlayer(mModel.priceMin.toString())
        }
        raise.setOnClickListener {
            if(!raiseValue.text.toString().isEmpty())
                mModel.nextPlayer(raiseValue.text.toString())
        }

        raiseValue.hint = getString(R.string.hint_price)
        raiseValue.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                raise.isEnabled = !raiseValue.text.toString().isEmpty() && raiseValue.text.toString().toInt() > mModel.priceMin
                raise.alpha = if(raise.isEnabled){1f}else{0.2f}
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })
    }

    override fun finish() {
        if(mModel.step == 0)
            (activity as NewHandActivity).mModel.history.preflop = HelperHistory.formatedHistoryFromArray(mModel.preflop)

        if(mModel.step == 1)
            (activity as NewHandActivity).mModel.history.flop = HelperHistory.formatedHistoryFromArray(mModel.flop)

        if(mModel.step == 2)
            (activity as NewHandActivity).mModel.history.turn = HelperHistory.formatedHistoryFromArray(mModel.turn)

        if(mModel.step == 3)
            (activity as NewHandActivity).mModel.history.river = HelperHistory.formatedHistoryFromArray(mModel.river)

        (activity as NewHandActivity).supportFragmentManager.popBackStack()
    }

    @SuppressLint("SetTextI18n")
    override fun nextPlay() {

        raiseValue.setText("")

        if(mModel.priceMin == 0){
            action.text = getString(R.string.check)
        } else if(mModel.priceMin == mModel.history!!.bigBlind && mModel.step == 0){
            action.text = getString(R.string.limp)
        } else {
            action.text = getString(R.string.call)
        }
        position.setText(mModel.getPosByCurrentPosInList(mModel.getCurPosInListByStep(),mModel.step))


        when(mModel.step){
            0 -> {
                step.text = getString(R.string.pre_flop)
            }
            1 -> {
                if(step.text != getString(R.string.flop)) {
                    card1.setImageResource(HelperHistory.getImageHand(mModel.history!!.board!!)[0])
                    card2.setImageResource(HelperHistory.getImageHand(mModel.history!!.board!!)[1])
                    card3.setImageResource(HelperHistory.getImageHand(mModel.history!!.board!!)[2])
                    step.text = getString(R.string.flop)
                }
            }
            2 -> {
                if(step.text != getString(R.string.turn)) {
                    card4.setImageResource(HelperHistory.getImageHand(mModel.history!!.board!!)[3])
                    step.text = getString(R.string.turn)
                }
            }
            3 -> {
                if(step.text != getString(R.string.river)) {
                    card5.setImageResource(HelperHistory.getImageHand(mModel.history!!.board!!)[4])
                    step.text = getString(R.string.river)
                }
            }
        }

        actions.text = """
                |Preflop : ${mModel.getValueStringBoard(mModel.preflop,0)}
                |Flop : ${mModel.getValueStringBoard(mModel.flop,1)}
                |Turn : ${mModel.getValueStringBoard(mModel.turn,2)}
                |River : ${mModel.getValueStringBoard(mModel.river,3)}
         """.trimMargin()

    }
}