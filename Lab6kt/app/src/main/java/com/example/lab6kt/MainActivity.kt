package com.example.lab6kt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_toast = findViewById<Button>(R.id.btn_toast)    //將六個變數與xml的元件綁定
        val btn_custom = findViewById<Button>(R.id.btn_custom)
        val btn_snackbar = findViewById<Button>(R.id.btn_snackbar)
        val btn_dialog1 = findViewById<Button>(R.id.btn_dialog1)
        val btn_dialog2 = findViewById<Button>(R.id.btn_dialog2)
        val btn_dialog3 = findViewById<Button>(R.id.btn_dialog3)
        val opt = arrayOf("選項 1", "選項 2", "選項 3", "選項 4", "選項 5")  //建立要列表上的字串

        btn_toast.setOnClickListener {
            showToast("預設 Toast")   //showToast
        }

        btn_custom.setOnClickListener {
            val toast = Toast(this) //宣告Toast
            toast.setGravity(Gravity.TOP, 0, 50)    //Toast顯示位置
            toast.duration = Toast.LENGTH_SHORT //Toast的顯示時間
            toast.view = layoutInflater.inflate(R.layout.custom_toast, null)    //放入自定義的畫面custom_toast.xml
            toast.show()    //顯示Toast
        }

        btn_snackbar.setOnClickListener {
            Snackbar.make(it, "按鈕式 Snackbar", Snackbar.LENGTH_SHORT)    //建立Snackbar
                .setAction("按鈕") {
                    showToast("已回應")
                }.show()
        }

        btn_dialog1.setOnClickListener {
            //建立AlertDialog
            AlertDialog.Builder(this)
                .setTitle("按鈕式 AlertDialog")
                .setMessage("AlertDialog 內容")
                .setNeutralButton("左按鈕") { dialog, which ->
                    showToast("左按鈕")
                }
                .setNegativeButton("中按鈕") { dialog, which ->
                    showToast("中按鈕")
                }
                .setPositiveButton("右按鈕") { dialog, which ->
                    showToast("右按鈕")
                }.show()
        }

        btn_dialog2.setOnClickListener {
            //建立AlertDialog
            AlertDialog.Builder(this)
                .setTitle("列表式 AlertDialog")
                .setItems(opt) { dialogInterface, i ->
                    showToast("你選的是${opt[i]}")
                }.show()
        }

        btn_dialog3.setOnClickListener {
            var position = 0
            //建立AlertDialog
            AlertDialog.Builder(this)
                .setTitle("單選式 AlertDialog")
                .setSingleChoiceItems(opt, 0) { dialogInterface, i ->
                    position = i
                }
                .setPositiveButton("確定") { dialog, which ->
                    showToast("你選的是${opt[position]}")
                }.show()
        }
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}