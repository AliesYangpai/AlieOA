package org.alieoa.work.test

class TestRepoUser {
    fun loadTestUserInfo():TestUserData {
        return TestUserData("张三",15)
    }

    fun loadTestUserInfo(age:Short):TestUserData {
        return TestUserData("张三",age)
    }
}