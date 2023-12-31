package com.muhammed.custompopupwindow

import android.app.Activity
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.PopupWindow

/**
 * Created by Muhammed COBANOGLU on 20.07.2023.
 */
class CustomPopupWindow(
    act: Activity,
    layout: Int
) : PopupWindow(
    LinearLayout.LayoutParams.MATCH_PARENT, // width
    LinearLayout.LayoutParams.WRAP_CONTENT // height
) {

    private val inflater: LayoutInflater = act.layoutInflater
    private val view = inflater.inflate(layout, null)
    private val slide = Slide()
    private val activity = act

    init {
        this.contentView = view
        this.elevation = 10.0F
        this.slide.slideEdge = Gravity.BOTTOM
        this.enterTransition = slide
        this.exitTransition = slide
        this.isOutsideTouchable = true
        this.isFocusable = true
        this.isOutsideTouchable = true
    }

    fun setCustomElevation(newElevation: Float) {
        this.elevation = newElevation
    }

    fun setEnterTransition(newDirection: Int = Gravity.BOTTOM) {
        val slideIn = Slide()
        slideIn.slideEdge = newDirection
        this.enterTransition = slideIn
    }

    fun setExitTransition(newDirection: Int = Gravity.BOTTOM) {
        val slideOut = Slide()
        slideOut.slideEdge = newDirection
        this.exitTransition = slideOut
    }

    fun makeTouchable() {
        activity.window.clearFlags(
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
        )
    }

    fun makeNotTouchable() {
        activity.window.setFlags(
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
        )
    }

    fun showPopupAsDropdown(
        view: View
    ) {
        this.showAsDropDown(view)
        this.update()
    }

    fun showPopup(
        location: ViewGroup,
        position: Int = Gravity.NO_GRAVITY,
        x_offset: Int = 0,
        y_offset: Int = 100
    ) {
        TransitionManager.beginDelayedTransition(location)
        this.showAtLocation(
            location,
            position,
            x_offset,
            y_offset
        )
        this.update()
    }

    fun hidePopup() {
        this.dismiss()
        activity.window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    }
}