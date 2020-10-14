package org.alieoa.work.test

class TestValue {
    companion object {
        fun getTestContacts(): ArrayList<TestContact> {

            val testContacts = ArrayList<TestContact>()
            testContacts.add(TestContact("张三"))
            testContacts.add(TestContact("张四"))
            testContacts.add(TestContact("张午"))
            testContacts.add(TestContact("张器"))
            testContacts.add(TestContact("赵二"))
            testContacts.add(TestContact("王一"))
            testContacts.add(TestContact("李四"))
            return testContacts
        }
    }
}