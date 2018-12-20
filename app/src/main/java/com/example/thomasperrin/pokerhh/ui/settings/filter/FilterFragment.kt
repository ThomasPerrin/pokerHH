package com.example.thomasperrin.pokerhh.ui.settings.filter

import android.os.Bundle
import android.view.View
import androidx.preference.*
import com.example.thomasperrin.pokerhh.R

class FilterFragment: PreferenceFragmentCompat() {

    private var rootView: View? = null

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences_filter, rootKey)

        val summaryProvider = Preference.SummaryProvider<SwitchPreference>{
            if(it.isChecked){
                "lastSync at "
            } else {
                "aze"
            }
        }
        findPreference("training").summaryProvider = summaryProvider
    }



}