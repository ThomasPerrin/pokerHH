package com.example.thomasperrin.pokerhh.di

import com.example.thomasperrin.pokerhh.ui.account.AccountFragment
import com.example.thomasperrin.pokerhh.ui.allhands.AllHandsFragment
import com.example.thomasperrin.pokerhh.ui.displayhand.DisplayHandActivity
import com.example.thomasperrin.pokerhh.ui.filter.FilterActivity
import com.example.thomasperrin.pokerhh.ui.main.MainActivity
import com.example.thomasperrin.pokerhh.ui.myhands.MyHandsFragment
import com.example.thomasperrin.pokerhh.ui.newhand.NewHandActivity
import com.example.thomasperrin.pokerhh.ui.newhand.flow.HistoryFlowFragment
import com.example.thomasperrin.pokerhh.ui.newhand.pickcard.PickCardFragment

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuildersModule {

    @ContributesAndroidInjector
    internal abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    internal abstract fun bindDisplayActivity(): DisplayHandActivity

    @ContributesAndroidInjector
    internal abstract fun bindDisplayFragment(): AllHandsFragment

    @ContributesAndroidInjector
    internal abstract fun bindMyHandsFragment(): MyHandsFragment

    @ContributesAndroidInjector
    internal abstract fun bindNewHandsActivity(): NewHandActivity

    @ContributesAndroidInjector
    internal abstract fun bindAccountFragment(): AccountFragment

    @ContributesAndroidInjector
    internal abstract fun bindFlowFragment(): HistoryFlowFragment

    @ContributesAndroidInjector
    internal abstract fun bindPickCardFragment(): PickCardFragment

    @ContributesAndroidInjector
    internal abstract fun bindFilterActivity(): FilterActivity

}