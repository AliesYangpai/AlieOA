package org.alieoa.work

import com.google.gson.Gson
import org.alieoa.work.db.entity.User

/**
 * Created by Administrator on 2020/8/29 0029.
 * 类描述
 * 版本
 */
//object Util {
//    val name = "xxxx"
//    fun play(){}
//}

class Util {
    companion object {
        val name = "xxxx"
        fun play(){}
        fun doGenerateUser():String{
            var user = User()
            user.userName = "Alie"
            user.userId = 1
            user.balance = 55F
            user.avatar = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1601545158755&di=9cce5ed9776c4267b6600af74338caa3&imgtype=0&src=http%3A%2F%2Fwww.clbao.cn%2Fdata%2Fupfiles%2F20151223%2F14041450838347934.jpg"
            user.fullName = "AlieYangpai"
            user.phone = "1155112266"
            user.nickName = "yangpai"

            var gson = Gson()
            return gson.toJson(user)
        }
    }
}