package com.diagnal.programming.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diagnal.programming.R
import com.diagnal.programming.`interface`.OnPosterClickListener
import com.diagnal.programming.databinding.ItemPosterBinding
import com.diagnal.programming.model.Content
import com.diagnal.programming.model.Page

class PostersListAdapter(
    var listener: OnPosterClickListener,
    var posterList: ArrayList<Content> = arrayListOf()
) : RecyclerView.Adapter<PostersListAdapter.PosterViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PosterViewHolder {
        val itemPosterViewBinding =
            ItemPosterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PosterViewHolder(itemPosterViewBinding)
    }

    override fun onBindViewHolder(holder: PosterViewHolder, position: Int) {
        holder.bind(posterList[position], listener)
    }

    override fun getItemCount(): Int {
        return posterList.size
    }

    class PosterViewHolder(private val itemPosterViewBinding: ItemPosterBinding) :
        RecyclerView.ViewHolder(itemPosterViewBinding.root), View.OnClickListener{
        private var listener: OnPosterClickListener? = null
        private var poster: Content? = null
        fun bind(poster: Content, listener: OnPosterClickListener) {
            this.listener = listener
            this.poster = poster
            itemPosterViewBinding.apply {

                posterItem = poster
                onClick = this@PosterViewHolder
                executePendingBindings()
            }
        }

        override fun onClick(v: View?) {
            when (v?.id) {
                R.id.imgPoster -> {
                    poster?.let { listener?.onPosterClick(it, adapterPosition) }
                }
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItemList(itemList: ArrayList<Content>) {
        this.posterList = itemList
        notifyDataSetChanged()
    }
}