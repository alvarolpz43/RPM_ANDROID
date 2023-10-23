package com.example.loginexample.ui.utils.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.loginexample.R
import com.example.loginexample.data.model.web.UserData
import com.example.loginexample.databinding.ItemUsersBinding

class UserAdapter(val users : List<UserData>) : RecyclerView.Adapter<UserHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return UserHolder(layoutInflater.inflate(R.layout.item_users, parent, false))
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.render(users[position])
    }
}

class UserHolder(view:View) : ViewHolder(view){
    private val binding = ItemUsersBinding.bind(view)

    fun render(usersData: UserData){
        binding.txtNombre.text = usersData.nombre1_mv
        binding.txtNacionalidad.text = usersData.nacionalidad
    }
}