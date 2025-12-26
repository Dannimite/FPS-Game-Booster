package com.game.fpsbooster

import android.view.Choreographer

class TouchLatencyBooster {

    fun boost() {
        try {
            Choreographer.getInstance().postFrameCallback {
                // no-op frame callback to hint frame pipeline
            }
        } catch (e: Exception) { }
    }
}
