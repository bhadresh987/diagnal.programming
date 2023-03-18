package com.diagnal.programming.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.diagnal.programming.MainViewModel
import com.diagnal.programming.R
import com.diagnal.programming.adapter.PostersListAdapter
import com.diagnal.programming.databinding.ActivityMainBinding
import com.diagnal.programming.model.Content
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
//    private val TAG = "MainActivity"
    private val viewModel: MainViewModel by inject()
    private var adapter: PostersListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        observeFromViewModal()
        viewModel.fetchPoster(this)


    }

    private fun observeFromViewModal() {
        viewModel.cards.observe(this) {
//                cards ->
            adapter?.setItemList(it as ArrayList<Content>)
            binding.recyclerViewPoster.layoutManager = GridLayoutManager(this, 2)
            binding.recyclerViewPoster.adapter = adapter
//            Log.d(TAG, "The count of the cards: ${cards.count()}")
        }
    }

//    override fun onPosterClick(poster: Content, position: Int) {
//        TODO("Not yet implemented")
//    }
}