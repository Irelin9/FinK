package com.example.irelin.fink.data.models

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


open class Transaction(var text: String, var sum: Float = 0f) : RealmObject() {
    @PrimaryKey
    lateinit var id: String

    constructor() : this("some text") {
    }
}