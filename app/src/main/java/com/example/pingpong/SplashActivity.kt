package com.example.pingpong

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import com.example.pingpong.databinding.ActivitySplashBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAnimation()
    }
    private fun initAnimation() {
        val anim = AnimationUtils.loadAnimation(this, R.anim.splash)
        binding.ivLogo.startAnimation(anim)
        binding.ivLogoName.startAnimation(anim)

        startPlayers()
    }

    private fun startPlayers() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, PlayerActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}