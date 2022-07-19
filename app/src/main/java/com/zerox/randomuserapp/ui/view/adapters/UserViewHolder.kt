package com.zerox.randomuserapp.ui.view.adapters

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.zerox.randomuserapp.data.model.entities.user.User
import com.zerox.randomuserapp.databinding.UserItemBinding
import com.zerox.randomuserapp.ui.view.UserDetailsActivity

class UserViewHolder(view:View):RecyclerView.ViewHolder(view){

    private val binding = UserItemBinding.bind(view)
    fun bind(user: User){
        binding.tvUserName.text = user.name.first
        binding.tvUserMail.text = user.email
        binding.cvElement.setOnClickListener{
            val intent = Intent(binding.root.context,UserDetailsActivity::class.java)
            intent.putExtra("user_id",user.id.value)
            binding.root.context.startActivity(intent)
        }
    }
}