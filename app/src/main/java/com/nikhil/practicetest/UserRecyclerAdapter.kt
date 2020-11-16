package com.nikhil.practicetest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nikhil.practicetest.databinding.ItemUserDataBinding

class UserRecyclerAdapter : ListAdapter<User, UserRecyclerAdapter.UserViewHolder>(UserDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder.fromView(parent)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class UserViewHolder(private val inflate: ItemUserDataBinding)
        : RecyclerView.ViewHolder(inflate.root) {

        companion object {
            fun fromView(parent: ViewGroup)  : UserViewHolder{
                val inflate = DataBindingUtil.inflate<ItemUserDataBinding>(
                    LayoutInflater.from(parent.context),
                    R.layout.item_user_data,
                    parent,
                    false
                )
                return UserViewHolder(inflate)
            }
        }

        fun bind(user: User) {
            inflate.user = user
            inflate.executePendingBindings()
        }

    }
}

class UserDiffUtil : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }

}
