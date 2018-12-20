package com.example.thomasperrin.pokerhh.ui.newhand.pickcard

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import androidx.lifecycle.Observer
import com.afollestad.materialdialogs.MaterialDialog
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
    var mat: MaterialDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mModel.setInteractor(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_pick_card, container, false)
        mModel.flop1.observe(this, Observer<Int>{ board.card1.setImageResource(it) })
        mModel.flop2.observe(this, Observer<Int>{ board.card2.setImageResource(it) })
        mModel.flop3.observe(this, Observer<Int>{ board.card3.setImageResource(it) })
        mModel.turn.observe(this, Observer<Int>{ board.card4.setImageResource(it) })
        mModel.river.observe(this, Observer<Int>{ board.card5.setImageResource(it) })
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        container.setOnClickListener { onBack() }

        textCard1.addTextChangedListener(textChangeListener(1))
        textCard2.addTextChangedListener(textChangeListener(2))
        textCard3.addTextChangedListener(textChangeListener(3))
        textCard4.addTextChangedListener(textChangeListener(4))
        textCard5.addTextChangedListener(textChangeListener(5))

    }

    private fun textChangeListener(pos: Int):TextWatcher{
        return object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if(p0.toString().length in 2..3){
                    if(!mModel.setCardSelected(p0.toString(),pos)){
                        mModel.setBlueCard(pos)
                        mat = MaterialDialog(context!!).show {
                            title(text = "Ah...")
                            message(text = "Cette carte est déjà utilisée !!")
                        }
                    }
                } else {
                    mModel.setBlueCard(pos)
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        }
    }


    override fun onBack() {
        if(mModel.canValidate()) {
            (activity!! as NewHandActivity).mModel.board.value =
                    "${textCard1.text}|${textCard2.text}|${textCard3.text}|${textCard4.text}|${textCard5.text}"
            (activity!! as NewHandActivity).supportFragmentManager.popBackStack()
        } else {
            mat = MaterialDialog(context!!).show {
                title(text = "Ah...")
                message(text = "Le board n'est pas valide !!")
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.validate -> {
                onBack()
            }
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_pick_card, menu)
    }

    override fun validate() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}