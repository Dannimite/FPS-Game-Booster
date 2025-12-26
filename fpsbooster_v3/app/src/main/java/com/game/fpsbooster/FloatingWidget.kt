package com.game.fpsbooster

import android.content.Context
import android.view.LayoutInflater
import android.view.WindowManager
import android.graphics.PixelFormat

class FloatingWidget(val ctx: Context) {
    fun show() {
        val windowManager = ctx.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val widgetView = LayoutInflater.from(ctx).inflate(R.layout.dialog_profile, null)
        val params = WindowManager.LayoutParams(
            150, 150,
            WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
            PixelFormat.TRANSLUCENT
        )
        try {
            windowManager.addView(widgetView, params)
        } catch (e: Exception) {
            // ignore if no permission
        }
    }
}
