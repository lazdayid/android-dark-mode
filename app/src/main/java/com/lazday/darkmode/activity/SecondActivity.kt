package com.lazday.darkmode.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lazday.darkmode.R
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        supportActionBar!!.title = "Hi"

        button.setOnClickListener {
            finish()
        }
    }
}