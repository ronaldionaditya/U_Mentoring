package com.mobile.umentoring.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.mobile.umentoring.R
import com.mobile.umentoring.adapter.HomeFragment
import com.mobile.umentoring.adapter.MenuActivity
import com.mobile.umentoring.pref.SessionManager

class SplashScreenActivity : AppCompatActivity() {

    lateinit var pref : SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        pref = SessionManager(this)

        val handler = Handler()
        handler.postDelayed({

            val sessionManager = SessionManager(this)
            if (sessionManager.login?:true){
                val intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)
            }else{
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            finish()
        }, 5000)
    }
}