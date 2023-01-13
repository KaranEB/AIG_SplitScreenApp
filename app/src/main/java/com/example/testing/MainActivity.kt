package com.example.testing

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.ActivityOptionsCompat


class MainActivity : AppCompatActivity() {

    val KEY_LAUNCH_WINDOWING_MODE = "android.activity.windowingMode"
    val WINDOWING_MODE_SPLIT_SCREEN_PRIMARY = 3
    val KEY_SPLIT_SCREEN_CREATE_MODE = "android:activity.splitScreenCreateMode"
    val SPLIT_SCREEN_CREATE_MODE_TOP_OR_LEFT = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            openUrlInAdjacentWindow("https:www.google.co.in/")
        }
    }

    fun openUrlInAdjacentWindow(url: String) {
        val options = ActivityOptionsCompat.makeBasic().toBundle()?.apply {
            putInt(
                KEY_LAUNCH_WINDOWING_MODE,
                WINDOWING_MODE_SPLIT_SCREEN_PRIMARY
            )
//            putInt(
//                KEY_SPLIT_SCREEN_CREATE_MODE,
//                SPLIT_SCREEN_CREATE_MODE_TOP_OR_LEFT
//            )
        }

//        Intent(Intent.ACTION_VIEW).apply {
//            data = Uri.parse(url)
//            addFlags(Intent.FLAG_ACTIVITY_LAUNCH_ADJACENT or
//                    Intent.FLAG_ACTIVITY_NEW_TASK)
//        }.also { intent ->
//            startActivity(intent, options)
//        }

        val intent: Intent = Uri.parse("tel:5551234").let { number ->
            Intent(Intent.ACTION_DIAL, number)
        }
        startActivity(intent, options)
    }
}