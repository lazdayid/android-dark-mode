package com.lazday.darkmode.sharedpreferences

import android.content.Context
import android.content.SharedPreferences

private const val prefName = "LazdayDarkTheme.pref"

class PrefManager (context: Context) {

    private var sharedPref: SharedPreferences
    val editor: SharedPreferences.Editor

    init {
        sharedPref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
        editor = sharedPref.edit()
    }

    fun put(key: String, value: Boolean) {
        editor.putBoolean(key, value)
                .apply()
    }

    fun getBoolean(key: String): Boolean {
        return sharedPref.getBoolean(key, false)
    }
}