package com.game.fpsbooster

class PingOptimizer {

    fun optimize() {
        try {
            Runtime.getRuntime().exec(arrayOf("sh", "-c", "ndc resolver flushdefaultif || true"))
            Runtime.getRuntime().exec(arrayOf("sh", "-c", "ndc resolver flushif wlan0 || true"))
        } catch (e: Exception) { }
    }
}
