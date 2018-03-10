package com.example.irelin.fink.screens

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter

import com.example.irelin.fink.R
import com.example.irelin.fink.adapters.MainListAdapter
import com.example.irelin.fink.main.MainPresenter
import com.example.irelin.fink.main.MainView
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v4.app.ActivityOptionsCompat
import android.content.Intent
import android.view.View
import android.widget.Toast
import com.example.irelin.fink.data.models.Transaction
import com.example.irelin.fink.data.models.Currency


class MainActivity : MainView, MvpAppCompatActivity() {
    @InjectPresenter
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        transaction_add.setOnClickListener({ addTransaction() })
    }

    override fun onTransactionsLoaded(items: List<Transaction>) {
        main_list.adapter = MainListAdapter(items) {
            item, view -> openDetails(item, view)
        }
        main_list.layoutManager = LinearLayoutManager(this)
        /*menu_list.layoutManager = CenterZoomLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)*/
    }

    override fun updateView() {
        main_list.adapter.notifyDataSetChanged()
    }

    override fun openDetails(name: String, itemView: View) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(DetailsActivity.C_NAME, name)
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, itemView, "transactionImg")
        startActivity(intent, options.toBundle())
    }

    override fun onCourseLoaded(courses: Map<String, Currency>) {
        if (!courses.isEmpty()) {
            val usd = getString(R.string.usd)
            val eur = getString(R.string.eur)
            dollar.text = getString(R.string.currency_format_string, usd, formatCurrency(courses[usd]?.value))
            euro.text = getString(R.string.currency_format_string, eur, formatCurrency(courses[eur]?.value))
        }
    }

    override fun showError() {
        Toast.makeText(this, R.string.error_load_data, Toast.LENGTH_SHORT).show()
    }

    private fun addTransaction() {
        presenter.addTransaction()
    }

    private fun formatCurrency(value: Double?) = String.format("%1$,.2f", value ?: 0f)
}
