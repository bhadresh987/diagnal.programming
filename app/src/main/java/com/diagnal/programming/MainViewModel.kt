package com.diagnal.programming

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.diagnal.programming.model.Content
import com.diagnal.programming.model.Page
import com.diagnal.programming.utils.Utils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainViewModel(private val utils: Utils) : ViewModel() {
    private val mutableCards = MutableLiveData<List<Content>>()
    val cards: LiveData<List<Content>> get() = mutableCards

    fun fetchPoster(context: Context) {
        val jsonString = utils.getJson(context, "page.json")

        val gson = Gson()
        val listCardType = object : TypeToken<Page>() {}.type

        val cards = gson.fromJson<Page>(jsonString, listCardType)
        Log.d("Content", cards.page.contentItems.content.toString())
        mutableCards.value = cards.page.contentItems.content
    }
}