package com.twentyscoops.bsswitcher

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.browser.customtabs.CustomTabsIntent
import androidx.fragment.app.Fragment

abstract class SwitchMainFragment : Fragment(), SwitchCallback {

    private val switchManager: SwitchManager = SwitchManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context?.apply {
            switchManager.initial(this)
        }
    }

    override fun onResume() {
        super.onResume()
        switchManager.getStatus()?.apply {
            if (this == STATUS_DONE) switchManager.getResult(this@SwitchMainFragment)
        }
    }

    fun openBrowser(url: String, schemeKey: String) {
        switchManager.setState(STATUS_PENDING)
        context?.apply {
            val builder = CustomTabsIntent.Builder()
            builder.setToolbarColor(Color.BLUE)
            val customTabsIntent = builder.build()
            customTabsIntent.intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            customTabsIntent.launchUrl(
                this,
                Uri.parse(
                    "${url}${schemeKey}://"
                )
            )
        }
    }

    abstract override fun onSwitchResult(data: String)
}