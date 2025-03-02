package com.example.taller2_aplicacionesmoviles

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
    fun gotoingreso(view: View?) {
        startActivity(
            Intent(this, PefilActivity::class.java).apply {
                Intent.FLAG_ACTIVITY_SINGLE_TOP
            }
        );
        finish();
    };
    fun gotToRegistro2(view: View?) {
        startActivity(
            Intent(this, RegistroActivity::class.java).apply {
                Intent.FLAG_ACTIVITY_SINGLE_TOP
            }
        );
        finish();
    };
}