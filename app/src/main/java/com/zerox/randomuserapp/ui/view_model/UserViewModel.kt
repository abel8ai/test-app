package com.zerox.randomuserapp.ui.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zerox.randomuserapp.data.model.entities.user.User
import com.zerox.randomuserapp.data.network.UserService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userService: UserService
) : ViewModel() {

    val usersModel = MutableLiveData<MutableList<User>>()
    val userModel = MutableLiveData<User>()

    suspend fun getAllUsers(url: String) {
        usersModel.postValue(userService.getUsers(url).results)
    }

    suspend fun getUserByEmail(url: String, email: String) {
        val userList = userService.getUsers(url).results
        var postUser: User? = null
        for (user in userList) {
            if (user.email == email)
                postUser = user
        }
        if (postUser != null)
            userModel.postValue(postUser)
        else
            throw IllegalStateException("Usuario no encontrado")
    }
}