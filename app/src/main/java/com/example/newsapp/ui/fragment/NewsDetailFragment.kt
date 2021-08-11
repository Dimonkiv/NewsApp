package com.example.newsapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.data.model.News
import com.example.newsapp.databinding.NewsDetailFragmentBinding
import com.example.newsapp.presenter.NewsDetailPresenter
import com.example.newsapp.ui.App
import com.example.newsapp.ui.view.NewsDetailView

/**
 * Created by ivankiv on 11,August,2021
 */
class NewsDetailFragment : Fragment(),
    NewsDetailView {

    private lateinit var binding: NewsDetailFragmentBinding
    private lateinit var presenter: NewsDetailPresenter

    companion object {
        private const val ARG_ID = "ARG_NEWS_ID"

        fun instance(id: Long): NewsDetailFragment {
            return NewsDetailFragment().apply {
                val args = Bundle()
                args.putLong(ARG_ID, id)
                arguments = args
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createPresenter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.news_detail_fragment, container, false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.fetchNews()
    }

    private fun createPresenter() {
        presenter =
            NewsDetailPresenter((context?.applicationContext as App).provideNewsRepository())
        presenter.attachView(this)
        presenter.updateId(arguments?.getLong(ARG_ID, 0)!!)
    }

    override fun displayNews(item: News) {
        with(binding) {
           titleTv.text = item.title
           contentTv.text = item.content

            Glide.with(root)
                .load(item.imageUrl)
                .centerCrop()
                .into(imageView)
        }
    }
}