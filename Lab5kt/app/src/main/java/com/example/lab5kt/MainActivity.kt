package com.example.lab5kt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("MainActivity","onCreate")
        val adapter = ViewPagerAdapter(supportFragmentManager)  //建立FragmentPagerAdapter
        findViewById<ViewPager>(R.id.viewPager).adapter = adapter   //連接Adapter，讓Fragment與ViewPager建立關聯
    }
    override fun onRestart() {
        super.onRestart()
        Log.e("MainActivity","onRestart")
    }
    override fun onStart() {
        super.onStart()
        Log.e("MainActivity","onStart")
    }
    override fun onResume() {
        super.onResume()
        Log.e("MainActivity","onResume")
    }
    override fun onPause() {
        super.onPause()
        Log.e("MainActivity","onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.e("MainActivity","onStop")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.e("MainActivity","onDestroy")
    }
}

class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int) = when(position) {  //回傳對應的Fragment，決定頁面順序
        0 -> FirstFragment() //第一頁
        1 -> SecondFragment() //第二頁
        else -> ThirdFragment() //第三頁
    }
    override fun getCount() = 3 //回傳Fragment頁數
}