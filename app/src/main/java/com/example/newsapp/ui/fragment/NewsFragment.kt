package com.example.newsapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.R
import com.example.newsapp.data.model.News
import com.example.newsapp.databinding.NewsFragmentBinding
import com.example.newsapp.presenter.NewsPresenter
import com.example.newsapp.ui.App
import com.example.newsapp.ui.adapter.NewsAdapter
import com.example.newsapp.ui.view.NewsView

/**
 * Created by ivankiv on 11,June,2021
 */
class NewsFragment : Fragment(), NewsView {

    private lateinit var binding: NewsFragmentBinding
    private lateinit var presenter: NewsPresenter

    companion object {
        fun instance() = NewsFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createPresenter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.news_fragment, container, false)

        presenter.fetchNews()
        return binding.root
    }

    private fun createPresenter() {
        presenter = NewsPresenter((context?.applicationContext as App).provideNewsRepository())
        presenter.attachView(this)
    }

    override fun displayNews(items: List<News>) {
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = NewsAdapter(items)
        binding.recyclerView.adapter = adapter
    }
}