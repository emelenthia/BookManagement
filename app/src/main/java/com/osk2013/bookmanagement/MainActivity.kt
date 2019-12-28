package com.osk2013.bookmanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = ArrayList<String>()
        data.add("美味しい料理の本")
        data.add("難しい数学の本")
        data.add("愛おしい国語の本")
        data.add("好奇心は猫をも殺す理科の本")
        data.add("故きを温めて新しきを知る社会の本")

        val bookList = findViewById(R.id.bookList) as ListView

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data)

        bookList.adapter = adapter

        val bookAddButton = findViewById<Button>(R.id.book_add_button)
        bookAddButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(this@MainActivity, BookAddActivity::class.java)
                startActivity(intent)
            }
        })
    }

    override fun onClick(view: View?) {

    }
}
