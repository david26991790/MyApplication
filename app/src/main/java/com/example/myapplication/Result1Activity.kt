package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

const val KEY_r1 = "KEY_Result1"

class Result1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result1)
    }

    fun clickHornets(view: View) {

        var 圖片id: Int
        var 圖片名稱: String

        圖片id = R.drawable.hornets
        圖片名稱 = "黃蜂隊"

        val r1 = Result1(圖片id, 圖片名稱)
        Log.d("@@@ 寄結果", r1.toString())

        val intent = getIntent()
        intent.putExtra(KEY_r1, r1)

        setResult(RESULT_OK, intent);

        finish();
    }

    fun clickRockets(view: View) {

        var 圖片id: Int
        var 圖片名稱: String

        圖片id = R.drawable.rockets
        圖片名稱 = "火箭隊"

        val r1 = Result1(圖片id, 圖片名稱)
        Log.d("@@@ 寄結果", r1.toString())

        val intent = getIntent()
        intent.putExtra(KEY_r1, r1);

        setResult(RESULT_OK, intent);

        finish();

    }
}