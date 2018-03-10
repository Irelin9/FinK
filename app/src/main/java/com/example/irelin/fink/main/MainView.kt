package com.example.irelin.fink.main

import android.view.View
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.irelin.fink.data.models.Transaction
import com.example.irelin.fink.data.models.Currency

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface MainView : MvpView {
    fun onTransactionsLoaded(items : List<Transaction>)

    fun updateView()

    fun openDetails(name: String, itemView: View)

    fun showCourse(courses: Map<String, Currency>)

    fun showError()
}