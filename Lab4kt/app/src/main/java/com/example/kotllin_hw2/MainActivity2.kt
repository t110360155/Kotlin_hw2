package com.example.kotllin_hw2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val btn_send = findViewById<Button>(R.id.btn_send)  //宣告並綁定變數與元件
        val ed_drink = findViewById<EditText>(R.id.ed_drink)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val radioGroup2 = findViewById<RadioGroup>(R.id.radioGroup2)

        btn_send.setOnClickListener {
            if (ed_drink.length() < 1)
                Toast.makeText(this, "請輸入飲料名稱", Toast.LENGTH_SHORT).show()
            else {
                val b = Bundle()    //宣告一個bundle

                b.putString("drink", ed_drink.text.toString())  //將這三行資料放入bundle
                b.putString("sugar", radioGroup.findViewById<RadioButton>(radioGroup.checkedRadioButtonId).text.toString())
                b.putString("ice", radioGroup2.findViewById<RadioButton>(radioGroup2.checkedRadioButtonId).text.toString())

                setResult(Activity.RESULT_OK, Intent().putExtras(b))    //標記執行狀態ok及記錄Intent
                finish()    //結束視窗回到Activity1
            }
        }
    }
}