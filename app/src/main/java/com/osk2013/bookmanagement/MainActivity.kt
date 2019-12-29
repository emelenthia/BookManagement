package com.osk2013.bookmanagement

import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import com.osk2013.bookmanagement.adapter.BookInfoAdapter
import com.osk2013.bookmanagement.dto.BookInfoDto
import io.realm.Realm
import io.realm.RealmConfiguration

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var realm: Realm? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Realmの初期化
        Realm.init(this)
        val config = RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build()
        Realm.setDefaultConfiguration(config)

        realm = Realm.getDefaultInstance()

        //テストデータの挿入
        if (realm!!.where(BookInfoDto::class.java).findAll().count() < 1) {
            realm?.executeTransaction { realm ->
                val obj = realm.createObject(BookInfoDto::class.java!!, 1)
                obj.title = "独習C++"
            }
            realm?.executeTransaction { realm ->
                val obj = realm.createObject(BookInfoDto::class.java!!, 2)
                obj.title = "ロベールのC++入門講座"
            }
            realm?.executeTransaction { realm ->
                val obj = realm.createObject(BookInfoDto::class.java!!, 3)
                obj.title = "Effective C++"
            }
            realm?.executeTransaction { realm ->
                val obj = realm.createObject(BookInfoDto::class.java!!, 4)
                obj.title = "C/C++ミスプログラミングケーススタディ"
            }
            realm?.executeTransaction { realm ->
                val obj = realm.createObject(BookInfoDto::class.java!!, 5)
                obj.title = "すべてのプログラマに効く 危険なプログラムの処法箋"
            }
        }


        val allBook = realm!!.where(BookInfoDto::class.java).findAll()

        val data = ArrayList<String>()
        allBook.forEach{
            data.add(it.title)
        }

        val bookList = findViewById(R.id.bookList) as ListView

        val adapter = BookInfoAdapter(this, allBook)

        bookList.adapter = adapter

        val bookAddButton = findViewById<Button>(R.id.book_add_button)
        bookAddButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick (v : View?) {
                val intent = Intent(this@MainActivity, BookAddActivity::class.java)
                startActivity(intent)
            }
        })

        val cameraBookAddButton = findViewById<Button>(R.id.book_add_camera_button)
        cameraBookAddButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick (v : View?) {
                val intent = Intent(this@MainActivity, CameraBookAddActivity::class.java)
                startActivity(intent)
            }
        })
    }

    override fun onClick(v: View?) {
    }

    override fun onDestroy() {
        super.onDestroy()
        realm?.close()
    }
}
