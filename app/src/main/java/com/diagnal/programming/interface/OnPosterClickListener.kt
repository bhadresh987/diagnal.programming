package com.diagnal.programming.`interface`

import com.diagnal.programming.model.Content
import com.diagnal.programming.model.Page

interface OnPosterClickListener {
    fun onPosterClick(poster: Content, position: Int)
}