package com.example.taller2_aplicacionesmoviles

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
class SplashActivity : AppCompatActivity() {
    private var SPLASH_TIME_OUT: Long = 3000;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("SplashActivity","onStart:niciando un activity splash")
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
    override fun onStart(){
        super.onStart()
        Log.d("SplashActivity","onStart:Activity Splash esta en primer plano")
    }
    override fun onPause() {
        super.onPause()
        Log.d("SplashActivity","onStart:Activity Splash esta en primer pausa")
    }

    override fun onStop() {
        super.onStop()
        Log.d("SplashActivity","onStart:Activity Splash esta en primer pausa")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SplashActivity","onStart:Activity Splash esta en primer destruida")
    }






    }
