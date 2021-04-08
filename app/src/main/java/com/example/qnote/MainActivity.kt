package com.example.qnote

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var pInfo: PackageInfo? = null
        try {
            pInfo = packageManager.getPackageInfo(packageName, 0)
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        val version = pInfo!!.versionName
        val versionText = findViewById<View>(R.id.copy) as TextView
        versionText.text = "©2021 All Rights Reserved v $version"

        Timer().schedule(object : TimerTask() {
            override fun run() {
                val i = Intent(this@MainActivity, LoginActivity::class.java)
                startActivity(i)
            }
        }, 2000)
    }
}