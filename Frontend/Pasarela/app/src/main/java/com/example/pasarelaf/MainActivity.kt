package com.example.pasarelaf

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        setContentView(R.layout.activity_inicio)
    }

    fun iniciologin(view: View) {
        val logi = Intent(this, Login::class.java)
        startActivity(logi)
    }

    fun inicioregis(view: View) {
        val regis = Intent(this, SignUp::class.java)
        startActivity(regis)
    }


}