package com.example.thomasperrin.pokerhh.ui.newhand.pickcard

import org.junit.Assert

import org.junit.Test

class PickCardViewModelTest {

    @Test
    fun canValidate(){
        val pickCardViewmodel = PickCardViewModel()
        pickCardViewmodel.cards.add("")
        pickCardViewmodel.canValidate()
        Assert.assertFalse(pickCardViewmodel.canValidate!!.value!!)
        pickCardViewmodel.cards.add("")
        pickCardViewmodel.canValidate()
        Assert.assertFalse(pickCardViewmodel.canValidate!!.value!!)
        pickCardViewmodel.cards.add("")
        pickCardViewmodel.canValidate()
        Assert.assertTrue(pickCardViewmodel.canValidate!!.value!!)
        pickCardViewmodel.cards.add("")
        pickCardViewmodel.canValidate()
        Assert.assertTrue(pickCardViewmodel.canValidate!!.value!!)
        pickCardViewmodel.cards.add("")
        pickCardViewmodel.canValidate()
        Assert.assertTrue(pickCardViewmodel.canValidate!!.value!!)
        pickCardViewmodel.cards.add("")
        pickCardViewmodel.canValidate()
        Assert.assertFalse(pickCardViewmodel.canValidate!!.value!!)
    }

    @Test
    fun testReturnBoard(){
        val pickCardViewmodel = PickCardViewModel()
        pickCardViewmodel.cards.add("sa")
        pickCardViewmodel.cards.add("sa")
        pickCardViewmodel.cards.add("sa")
        pickCardViewmodel.cards.add("sa")
        pickCardViewmodel.cards.add("sa")
        Assert.assertEquals(14, pickCardViewmodel.getHistoryBoard().length)
        pickCardViewmodel.cards.clear()
        pickCardViewmodel.cards.add("sa")
        pickCardViewmodel.cards.add("sa")
        pickCardViewmodel.cards.add("sa")
        Assert.assertEquals(8, pickCardViewmodel.getHistoryBoard().length)
        pickCardViewmodel.cards.add("s10")
        pickCardViewmodel.cards.add("c10")
        pickCardViewmodel.cards.add("d10")
        pickCardViewmodel.cards.add("d10")
        pickCardViewmodel.cards.add("d10")
        Assert.assertEquals(19, pickCardViewmodel.getHistoryBoard().length)
        pickCardViewmodel.cards.add("s10")
        pickCardViewmodel.cards.add("c10")
        pickCardViewmodel.cards.add("d10")
        pickCardViewmodel.cards.add("d10")
        pickCardViewmodel.cards.add("d10")
        Assert.assertEquals("s10|c10|d10|d10|d10", pickCardViewmodel.getHistoryBoard())
    }



}