package com.russihersi.githubuserdicodingsubmission

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_user_github.view.*

class UserAdapter(private val onItemClick: OnItemClick) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    var userAdapter = arrayListOf<User>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(LayoutInflater.from(parent.context)
        .inflate(R.layout.activity_user_github, parent, false))

    override fun getItemCount(): Int = userAdapter.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(userAdapter[position])
    }

    inner class ViewHolder(private val view : View) : RecyclerView.ViewHolder(view){

        fun onBind(user : User) = view.apply{
            github_name.text = user.Name
            img_user_github.setImageResource(user.Avatar)
            username_github.text = "@" +user.Username
            setOnClickListener{onItemClick(user)}
        }
    }
}

typealias OnItemClick = (User)-> Unit
