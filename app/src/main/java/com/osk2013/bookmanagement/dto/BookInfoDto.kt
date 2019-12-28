package com.osk2013.bookmanagement.dto

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

open class BookInfoDto: RealmObject() {

    @PrimaryKey
    var id : Int? = null
    @Required
    var title = ""

}