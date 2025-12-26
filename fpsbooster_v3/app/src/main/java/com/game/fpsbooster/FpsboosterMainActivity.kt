package com.game.fpsbooster

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class FpsboosterMainActivity : AppCompatActivity() {

    private lateinit var btnBoostFPS: Button
    private lateinit var btnCleanRAM: Button
    private lateinit var btnOptimizeNetwork: Button
    private lateinit var btnPreLaunchBoost: Button
    private lateinit var tvCurrentGame: TextView
    private lateinit var tvFPS: TextView
    private lateinit var spinnerProfiles: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnBoostFPS = findViewById(R.id.btnBoostFPS)
        btnCleanRAM = findViewById(R.id.btnCleanRAM)
        btnOptimizeNetwork = findViewById(R.id.btnOptimizeNetwork)
        btnPreLaunchBoost = findViewById(R.id.btnPreLaunchBoost)
        tvCurrentGame = findViewById(R.id.tvCurrentGame)
        tvFPS = findViewById(R.id.tvFPS)
        spinnerProfiles = findViewById(R.id.spinnerProfiles)

        btnBoostFPS.setOnClickListener { startBoostService() }
        btnCleanRAM.setOnClickListener { cleanRAM() }
        btnOptimizeNetwork.setOnClickListener { optimizeNetwork() }
        btnPreLaunchBoost.setOnClickListener { preLaunchBoost() }

        tvCurrentGame.text = "Current Game: " + GameDetector.getCurrentGame(this)
    }

    private fun startBoostService() {
        val intent = Intent(this, FpsboosterBoostServiceV3::class.java)
        intent.putExtra("game_package", GameDetector.getCurrentGame(this))
        startService(intent)
    }

    private fun cleanRAM() { /* Implement RAM cleaning here */ }
    private fun optimizeNetwork() { PingOptimizer().optimize() }
    private fun preLaunchBoost() { PreLaunchOptimizer().preloadAssets(GameDetector.getCurrentGame(this)) }
}
