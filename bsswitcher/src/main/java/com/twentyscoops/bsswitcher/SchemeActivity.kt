package com.twentyscoops.bsswitcher

import android.app.Activity
import android.os.Bundle

class SchemeActivity : Activity() {
    private val manager = SwitchManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        manager.initial(this, intent)
        finish()
    }
}