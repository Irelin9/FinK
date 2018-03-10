package com.example.irelin.fink.screens

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter

import com.example.irelin.fink.R
import com.example.irelin.fink.details.DetailsPresenter
import com.example.irelin.fink.details.DetailsView
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : MvpAppCompatActivity(), DetailsView {
    companion object {
        val C_NAME: String = "name"
    }

    @InjectPresenter
    lateinit var presenter: DetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        presenter?.title = savedInstanceState?.getString(C_NAME) ?: "no title"
    }

    override fun setTitle(title: String) {
        transaction_title.text = title
    }
}
