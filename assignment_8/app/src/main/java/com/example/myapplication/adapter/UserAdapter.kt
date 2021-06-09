package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.api.dto.User
import kotlinx.android.synthetic.main.inner.view.*
import kotlinx.android.synthetic.main.list.view.*

class UserAdapter(private val data: List<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.inner, parent, false))
    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        holder.inneremail.text=data[position].email.toString()
        holder.innerfirstname.text=data[position].firstName.toString()
        holder.innerlastname.text=data[position].lastName.toString()
        Glide.with(holder.itemView.context).load(data[position].avatar).into(holder.inneravatar)

    }

    override fun getItemCount(): Int {
        return data.size

    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val inneravatar = itemView.inneravatar
        val innerfirstname = itemView.innerfirstname
        val innerlastname = itemView.innerlastname
        val inneremail = itemView.inneremail
    }
}