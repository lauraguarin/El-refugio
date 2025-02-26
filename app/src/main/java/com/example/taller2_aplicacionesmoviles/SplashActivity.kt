package com.example.taller2_aplicacionesmoviles

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
class SplashActivity : AppCompatActivity() {
    private var SPLASH_TIME_OUT: Long = 5000;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            // Mostrar una vista o layout
            setContentView(R.layout.activity_splash);

            // Llevar a MainActivity
            Handler(mainLooper).postDelayed({
                startActivity(
                    Intent(this, Home_Activity::class.java).apply {
                        Intent.FLAG_ACTIVITY_SINGLE_TOP
                    }
                );
                finish();
            }, SPLASH_TIME_OUT);
        }
    }
