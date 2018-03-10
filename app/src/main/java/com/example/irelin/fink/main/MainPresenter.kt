package com.example.irelin.fink.main

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.irelin.fink.custom.Application
import com.example.irelin.fink.data.course.ICourseRepository
import com.example.irelin.fink.data.transaction.ITransactionsRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@InjectViewState
class MainPresenter : MvpPresenter<MainView>() {
    @Inject
    lateinit var courseRepository : ICourseRepository
    @Inject
    lateinit var transactionsRepository : ITransactionsRepository

    private var disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        Application.appComponent.inject(this)
        loadList()
        loadCourse()
    }

    private fun loadList() {
        val transactionsObservable = transactionsRepository.getTransactions()
        disposables.add(transactionsObservable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { response -> viewState.onTransactionsLoaded(response) },
                        { viewState.showError() }
                ))
    }

    private fun loadCourse() {
        val courseObservable = courseRepository.getCourse()
        disposables.add(courseObservable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { response -> viewState.showCourse(response) },
                        { viewState.showError() }
                ))
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }
}