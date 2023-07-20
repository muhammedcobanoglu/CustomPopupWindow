package com.muhammed.custompopupwindow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.muhammed.custompopupwindow.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var mBinding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding?.root)

        val myPopup = CustomPopupWindow(this, R.layout.custom_popup_window)
        mBinding?.showDialog?.setOnClickListener {
            myPopup.showPopupAsDropdown(it)
        }
    }
}