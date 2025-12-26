package com.game.fpsbooster

import android.content.Context
import android.app.ActivityManager

object GameDetector {

    private val supportedFPSGames = listOf(
        "com.activision.callofduty.shooter",
        "com.tencent.ig",
        "com.dts.freefireth",
        "com.epicgames.fortnite",
        "com.ea.gp.apexlegendsmobilefps"
    )

    fun getCurrentGame(ctx: Context): String {
        val am = ctx.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val runningApp = am.runningAppProcesses?.firstOrNull()?.processName ?: "None"
        return if (supportedFPSGames.contains(runningApp)) runningApp else "None"
    }
}
