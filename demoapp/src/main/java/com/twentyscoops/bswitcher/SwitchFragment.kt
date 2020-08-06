package com.twentyscoops.bswitcher

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.twentyscoops.bsswitcher.SwitchMainFragment
import kotlinx.android.synthetic.main.fragment_switch.*

class SwitchFragment : SwitchMainFragment() {

    override fun onSwitchResult(data: String) {
        tvResult.text = "Your fucking lovely color is :: $data"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_switch, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btnSubmit.setOnClickListener {
            openBrowser(
                "",
                ""
            )
        }
    }
}