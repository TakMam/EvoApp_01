package com.example.evoapp_01

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class SmartphoneLoss : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_smartphone_loss)

        // Activity開始時にIntentを取得し、文字列をセットする
        val intent: Intent = getIntent()
        val message: String = intent.getStringExtra(MainActivity().EXTRA_MESSAGE)
        val textView: TextView = findViewById(R.id.textView)
        textView.setText(message)

    }


    fun Telephone(view: View){
        val phoneNumber: String = "08050749746"

        val uri: Uri = Uri.parse("tel:" + phoneNumber)
        val intent: Intent = Intent(Intent.ACTION_DIAL, uri)
        startActivity(intent)
    }
}
