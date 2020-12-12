package com.lazday.darktheme.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.lazday.darktheme.R
import com.lazday.darktheme.sharedpreferences.PrefManager
import kotlinx.android.synthetic.main.activity_setting.*

class SettingActivity : AppCompatActivity() {

    private val pref by lazy { PrefManager(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        supportActionBar!!.title = "Setting"

        if (pref.getBoolean("pref_is_dark")) switch_theme.isChecked = true

        switch_theme.setOnCheckedChangeListener { compoundButton, checked ->
            if (checked) {
                pref.put("pref_is_dark", true)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                pref.put("pref_is_dark", false)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        }
    }
}