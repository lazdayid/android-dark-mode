package com.lazday.darkmode.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import com.lazday.darkmode.R
import com.lazday.darkmode.sharedpreferences.PrefManager
import kotlinx.android.synthetic.main.activity_setting.*

/**
 * Video Kursus Android Developer #1 Indonesia
 * https://lazday.com
 */

class SettingActivity : AppCompatActivity() {

    private val pref by lazy { PrefManager(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        supportActionBar!!.title = "Setting"

        if ( pref.getBoolean("pref_is_dark") ) switch_theme.isChecked = true

        switch_theme.setOnCheckedChangeListener { _, checked ->
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