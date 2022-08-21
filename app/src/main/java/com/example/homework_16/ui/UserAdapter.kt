package com.example.homework_16.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homework_16.databinding.ListItemBinding
import com.example.homework_16.model.DataX

class UserAdapter: PagingDataAdapter<DataX.User, UserAdapter.UserViewHolder>(UserItemCallback) {

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserViewHolder(
        ListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    inner class UserViewHolder(private val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val user = getItem(bindingAdapterPosition)
            binding.apply {
                Glide.with(binding.imageView)
                    .load(user?.avatar)
                    .into(binding.imageView)
                tvName.text = user?.firstName
                tvLastname.text = user?.lastName
                tvEmail.text = user?.email
            }
        }
    }

    private object UserItemCallback: DiffUtil.ItemCallback<DataX.User>() {
        override fun areItemsTheSame(oldItem: DataX.User, newItem: DataX.User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: DataX.User, newItem: DataX.User): Boolean {
            return oldItem == newItem
        }
    }

}