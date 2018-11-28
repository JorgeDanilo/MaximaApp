package jdsistemas.me.appchallenge.activity

import android.os.Bundle
import android.app.Activity
import jdsistemas.me.appchallenge.R

import kotlinx.android.synthetic.main.activity_splash.*
import android.content.Intent
import android.os.Handler
import jdsistemas.me.appchallenge.R.id.showHome





class SplashActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val handler = Handler()
        handler.postDelayed(Runnable { showHome() }, 2000)
    }

    private fun showHome() {
        val intent = Intent(this@SplashActivity, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }

}
