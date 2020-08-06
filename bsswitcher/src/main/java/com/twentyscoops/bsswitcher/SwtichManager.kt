package com.twentyscoops.bsswitcher

import android.content.Context
import android.content.Intent

class SwitchManager {
    private var context: Context? = null
    private var manager: StateHolder = StateHolder()

    fun initial(context: Context, intent: Intent? = null) {
        this.context = context
        manager.newInstant(context)
        intent?.apply {
            setUpResult(data?.getQueryParameter(SCHEME_PARAM))
            setState(STATUS_DONE)
        }
    }

    fun setUpResult(data: String?) = manager.setData(data, RESULT_DATA_KEY)

    fun getResult(listen: SwitchCallback) {
        listen.onSwitchResult(manager.getData(RESULT_DATA_KEY) ?: "NONE")
        manager.clear(PREF_RESULT_KEY)
    }

    fun setState(statusCode: Int) = manager.setStatus(statusCode)

    fun getStatus(): Int? = manager.getState()
}
