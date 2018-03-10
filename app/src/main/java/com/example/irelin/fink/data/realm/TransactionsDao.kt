package com.example.irelin.fink.data.realm

import com.example.irelin.fink.data.models.Transaction
import io.reactivex.Observable
import io.realm.Realm
import java.util.*


class TransactionsDao {
    fun add() {
        Realm.getDefaultInstance().use {
            it.executeTransaction {
                var transaction = it.createObject(Transaction::class.java, UUID.randomUUID().toString())
                transaction.text = "description " + transaction.id
                transaction.sum = 25f
            }
        }
    }

    fun getAll(): Observable<List<Transaction>> {
        val realm = Realm.getDefaultInstance()
        return Observable.just(realm.copyFromRealm(realm.where(Transaction::class.java).findAll()))
                .take(10)
                .doOnComplete({ realm.close() })
    }
}