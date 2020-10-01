package org.alieoa.work.method

import org.alieoa.work.api.ApiHttpClient
import org.alieoa.work.api.UserService
import org.alieoa.work.callback.OnDataBackListener
import org.alieoa.work.db.entity.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class IUserImpl:IUser {
    override fun getUserInfo( onDataBackListener: OnDataBackListener<User>) {
        ApiHttpClient.getInstance().generateService(UserService::class.java)?.run {
            getUserInfo().enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    println("IUserImpl====onResponse:${response.body().toString()}")
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    println("IUserImpl====onFailure:${t.message}")
                }

            })
        }

    }
}