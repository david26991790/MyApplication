package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout

class ScrollActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll)
    }


    fun click_add(view: View) {


        var 圖片id: Int
        var 圖片名稱: String

        圖片id = R.drawable.rockets
        圖片名稱 = "火箭隊"

        val r1 = Result1(圖片id, 圖片名稱)
        Log.d("@@@ 寄結果", r1.toString())
        val intent = getIntent()
        intent.putExtra(KEY_r1, r1)

        setResult(RESULT_OK, intent);


        var li: LayoutInflater = LayoutInflater.from(this)

        var v: View = li.inflate(R.layout.student2, null, false)
        var ll: LinearLayout = findViewById(R.id.ll)
        ll.addView(v)
        var iv_1: ImageView = v.findViewById(R.id.iv_a)
        var iv_2: ImageView = v.findViewById(R.id.iv_b)
        iv_1.setImageResource(R.drawable.hornets)
        iv_2.setImageResource(R.drawable.rockets)

    }


}


