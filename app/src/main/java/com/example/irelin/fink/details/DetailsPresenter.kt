package com.example.irelin.fink.details

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

@InjectViewState
class DetailsPresenter : MvpPresenter<DetailsView>() {
    lateinit var title: String

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setTitle(title)
    }
}