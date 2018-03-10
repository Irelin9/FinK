package com.example.irelin.fink.data.transaction

import com.example.irelin.fink.data.models.Transaction
import io.reactivex.Observable
import io.reactivex.Single

class TransactionsRepository : ITransactionsRepository {
    override fun getTransactions(): Single<List<Transaction>> {
        return Observable
                .fromIterable(
                        listOf("item 1", "item 2", "item 3", "item 4", "item 5",
                                "item 6", "item 7", "item 8", "item 9", "item 10"))
                .map({ item -> Transaction(item) })
                .toList()
    }
}