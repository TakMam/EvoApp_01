package com.example.evoapp_01

import android.content.Intent
import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.util.Log


class MainActivity : AppCompatActivity() {

    val EXTRA_MESSAGE: String = "com.example.myapplication.MESSAGE"


    //onCreate：Activity初期化
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun sendMessage(view: View) {
        val intent: Intent = Intent(this@MainActivity, SmartphoneLoss::class.java)
        val editText: EditText = findViewById(R.id.editText) as EditText
        val message: String = editText.text.toString()
        intent.putExtra(EXTRA_MESSAGE, message)
        startActivity(intent)
    }

}