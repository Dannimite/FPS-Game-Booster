package com.game.fpsbooster

class CpuGpuManager {

    fun boost() {
        try {
            Runtime.getRuntime().exec(arrayOf("sh", "-c", "echo Boosting CPU/GPU performance"))
        } catch (e: Exception) { }
    }
}
