package com.game.fpsbooster

import android.content.Context
import android.view.LayoutInflater
import android.view.WindowManager
import android.graphics.PixelFormat
import android.widget.TextView

class FPSOverlayV3(val ctx: Context) {
    private val windowManager = ctx.getSystemService(Context.WINDOW_SERVICE) as WindowManager

    fun show(fps: Int, ping: Int, profile: String) {
        val overlayView = LayoutInflater.from(ctx).inflate(R.layout.overlay_fps, null)
        val tv = overlayView.findViewById<TextView>(R.id.tvFPSOverlay)
        tv.text = "FPS: $fps | Ping: $ping ms | Profile: $profile"

        val params = WindowManager.LayoutParams(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
            PixelFormat.TRANSLUCENT
        )
        try {
            windowManager.addView(overlayView, params)
        } catch (e: Exception) {
            // ignore if overlay permission not granted
        }
    }
}
