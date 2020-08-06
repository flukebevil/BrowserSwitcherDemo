package com.twentyscoops.bsswitcher

import android.content.Context

class StateHolder {
    private var context: Context? = null

    fun newInstant(context: Context) {
        this.context = context
    }

    fun setStatus(statusCode: Int) {
        val pref = context?.getSharedPreferences(STATUS, Context.MODE_PRIVATE)
        pref?.edit()?.putInt(STATUS, statusCode)?.apply()
    }

    fun getState(): Int? {
        val pref = context?.getSharedPreferences(STATUS, Context.MODE_PRIVATE)
        return pref?.getInt(STATUS, 0)
    }

    fun setData(data: String?, key: String) {
        val pref = context?.getSharedPreferences(PREF_RESULT_KEY, Context.MODE_PRIVATE)
        pref?.edit()?.putString(key, data)?.apply()
    }

    fun getData(key: String): String? {
        val pref = context?.getSharedPreferences(PREF_RESULT_KEY, Context.MODE_PRIVATE)
        return pref?.getString(key, null)
    }

    fun clear(key: String) =
        context?.getSharedPreferences(key, Context.MODE_PRIVATE)?.edit()?.clear()?.apply()
}