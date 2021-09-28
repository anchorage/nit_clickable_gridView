package com.example.company.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var demoList = MutableList<String>(31){x -> "$x"}
        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, demoList)
        gridView.adapter = adapter
        gridView.numColumns = 4
        gridView.setOnItemClickListener { adapterView, view, i, l ->
            var position = (view as TextView).text.toString().toInt()
            var row = (1 + position / gridView.numColumns)
            var col = (1 + position % gridView.numColumns)
            (view as TextView).setText("$row,$col")

        }

    }
}
