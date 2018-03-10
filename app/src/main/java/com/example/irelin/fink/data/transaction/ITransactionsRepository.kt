package com.example.irelin.fink.data.transaction

import com.example.irelin.fink.data.models.Transaction
import io.reactivex.Observable
import io.reactivex.Single


interface ITransactionsRepository {
    fun getTransactions() : Observable<List<Transaction>>

    fun addTransaction()
}