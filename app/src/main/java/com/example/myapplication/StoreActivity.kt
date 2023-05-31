package com.example.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.view.View
import android.util.Log
import android.widget.EditText
import java.io.FileNotFoundException
import java.io.IOException
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

class StoreActivity : AppCompatActivity() {

    private val filename = "st.ser"
    private var st: Student? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)
    }

    private fun buildStudent() {
        val a = findViewById<EditText>(R.id.et_name).text.toString()
        val b = findViewById<EditText>(R.id.et_eng).text.toString().toIntOrNull() ?: 0
        val c = findViewById<EditText>(R.id.et_math).text.toString().toIntOrNull() ?: 0
        st = Student(a, b, c)
        Log.d("@@@", st.toString())
    }

    private fun save() {
        try {
            val fos = openFileOutput(filename, Context.MODE_PRIVATE)
            val oos = ObjectOutputStream(fos)
            oos.writeObject(st)
            oos.close()
            fos.close()
            Log.d("@@@", "存檔成功")
            Toast.makeText(this, "存檔成功", Toast.LENGTH_SHORT).show()
        } catch (e: FileNotFoundException) {
            Log.d("@@@ 檔案找不到", e.toString())
        } catch (e: IOException) {
            Log.d("@@@ 輸出發生問題", e.toString())
        }
    }

    fun click_save(view: View) {
        buildStudent()
        save()
    }


    private fun load() {
        try {
            val fis = openFileInput(filename)
            val ois = ObjectInputStream(fis)
            st = ois.readObject() as Student?
            ois.close()
            fis.close()
            Log.d("@@@", "讀檔成功" + st.toString())
            Toast.makeText(this, "讀檔成功", Toast.LENGTH_SHORT).show()
        } catch (e: FileNotFoundException) {
            Log.d("@@@ 檔案找不到", e.toString())
        } catch (e: IOException) {
            Log.d("@@@ 輸出發生問題", e.toString())
        }
    }

    private fun show() {
        val tvName = findViewById<EditText>(R.id.et_name)
        val tvEng = findViewById<EditText>(R.id.et_eng)
        val tvMath = findViewById<EditText>(R.id.et_math)
        tvName.setText(st?.name)
        tvEng.setText(st?.eng.toString())
        tvMath.setText(st?.math.toString())
    }

    fun click_load(view: View) {
        load()
        show()
    }

    fun click_clear(view: View) {
        val tvName = findViewById<EditText>(R.id.et_name)
        val tvEng = findViewById<EditText>(R.id.et_eng)
        val tvMath = findViewById<EditText>(R.id.et_math)
        tvName.setText("")
        tvEng.setText("")
        tvMath.setText("")
    }



    fun btn_gohome(view: View) {
        var intent = Intent(this, ResultMainActivity::class.java )
        startActivity(intent)}

}





