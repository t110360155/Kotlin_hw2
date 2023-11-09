package com.example.kotllin_hw2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        data?.extras?.let {
            if (requestCode == 1 && resultCode == Activity.RESULT_OK) { //驗證
                findViewById<TextView>(R.id.tv_meal).text = //取得bundle資料
                    "飲料: ${it.getString("drink")}\n\n"+"甜度: ${it.getString("sugar")}\n\n"+"冰塊: ${it.getString("ice")}"
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn_choice).setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)    //Intent切換視窗到Activity2
            startActivityForResult(intent, 1)
        }
    }
}