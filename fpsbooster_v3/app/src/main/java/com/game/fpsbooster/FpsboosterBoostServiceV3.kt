package com.game.fpsbooster

import android.app.Service
import android.content.Intent
import android.os.IBinder

class FpsboosterBoostServiceV3 : Service() {

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val gamePackage = intent?.getStringExtra("game_package") ?: return START_STICKY

        PerformanceProfiler(this).applyAutoProfile(gamePackage)
        PreLaunchOptimizer().preloadAssets(gamePackage)
        CpuGpuManager().boost()
        TouchLatencyBooster().boost()
        PingOptimizer().optimize()
        FPSOverlayV3(this).show(60, 35, ProfileManager.currentProfile.name)
        FloatingWidget(this).show()

        return START_STICKY
    }
}
