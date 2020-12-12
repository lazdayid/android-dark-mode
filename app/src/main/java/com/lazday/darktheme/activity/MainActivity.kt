package com.lazday.darktheme.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatDelegate
import com.lazday.darktheme.R
import com.lazday.darktheme.sharedpreferences.PrefManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val pref by lazy { PrefManager(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (pref.getBoolean("pref_is_dark")) {
            AppCompatDelegate.setDefaultNightMode( AppCompatDelegate.MODE_NIGHT_YES )
        } else {
            AppCompatDelegate.getDefaultNightMode()
        }

        setContentView(R.layout.activity_main)

        textView.setOnClickListener {
            startActivity( Intent(this, SecondActivity::class.java) )
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_setting -> {
                startActivity( Intent(this, SettingActivity::class.java) )
            }
        }
        return super.onOptionsItemSelected(item)
    }
}