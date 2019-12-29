package com.osk2013.bookmanagement.dto

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required
import java.util.*

open class BookInfoDto: RealmObject() {

    @PrimaryKey
    var id: Int? = null

    //タイトル
    @Required
    var title = ""

    //タイトル(読み)
    var titleReading = ""

    //著者
    var author: RealmList<String>? = null

    //著者(読み)
    var authorReading: RealmList<String>? = null

    //発売日
    var releaseDate: Date? = null

    //ISBN
    var isbm = ""

    //既読
    var isReaded = false

    //ジャンル
    var genre: RealmList<String>? = null

    //画像url
    var imageUrl = ""
}
