package com.ysk423.fourquizkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        //viewの取得
        val btnClose:Button = findViewById(R.id.btnResultClose)

        //btnResultClose押したときの処理
        btnClose.setOnClickListener{
            finish()
        }
    }
}