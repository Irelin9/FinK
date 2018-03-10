package com.example.irelin.fink.data.transaction

import com.example.irelin.fink.data.models.Transaction
import io.reactivex.Single


interface ITransactionsRepository {
    fun getTransactions() : Single<List<Transaction>>
}