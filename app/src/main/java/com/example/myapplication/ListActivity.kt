package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.util.Log
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class ListActivity : AppCompatActivity() {

    val context = this
    var listView: ListView? = null
    var myListAdapter: MyListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        初始化ListView()

    }

    private fun 初始化ListView() {
        myListAdapter = MyListAdapter()
        listView = findViewById<ListView>(R.id.listview)
        listView?.adapter = myListAdapter
        listView?.emptyView = findViewById<TextView>(R.id.empty)
        listView?.setOnItemClickListener { parent, view, position, id ->
            val r2 = listView?.adapter?.getItem(position)
            val s = "position" + position + "" + r2.toString()
            Log.d("@@@", s)
        }
    }

    fun click_add(view: View) {
        myListAdapter?.drawableArrayList?.add(R.drawable.p04)

        val r2 = Result2("Mary", 86,83)
        myListAdapter?
    }

    inner class MyListAdapter : BaseAdapter() {
        val drawableArrayList = arrayListOf<Int>(
            R.drawable.p01,
            R.drawable.p02,
            R.drawable.p03,

        )
        val stArrayList = arrayListOf<Result2>(
            Result2("Tom",100,99),
            Result2("Amy",90,95),
            Result2("Jack",75,80),

        )

        override fun getItem(position: Int): Any {
            var r2 = stArrayList.get(position)
            return r2
        }


    }


}