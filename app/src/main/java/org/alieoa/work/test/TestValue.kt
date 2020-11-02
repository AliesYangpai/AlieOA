package org.alieoa.work.test

import org.alieoa.work.entity.ApproveBean

class TestValue {
    companion object {
        fun getTestContacts(): ArrayList<TestContact> {

            val testContacts = ArrayList<TestContact>()
            testContacts.add(TestContact("桐谷健太"))
            testContacts.add(TestContact("牧赖三使"))
            testContacts.add(TestContact("伊崎右典"))
            testContacts.add(TestContact("伊崎央登"))
            testContacts.add(TestContact("泷谷源治"))
            testContacts.add(TestContact("芹泽多摩雄"))
            testContacts.add(TestContact("林泽惠"))
            testContacts.add(TestContact("柴汽旋风雄"))
            testContacts.add(TestContact("明海大我"))
            testContacts.add(TestContact("赤司征十郎"))
            testContacts.add(TestContact("小栗旬"))
            testContacts.add(TestContact("鹫尾乡太"))
            testContacts.add(TestContact("伊崎瞬"))
            testContacts.add(TestContact("漆原凌"))
            testContacts.add(TestContact("山田孝之"))
            testContacts.add(TestContact("片铜权"))
            testContacts.add(TestContact("逢泽瑠加"))
            testContacts.add(TestContact("赵二"))
            testContacts.add(TestContact("王一"))
            return testContacts
        }

        fun getApproveList(): ArrayList<ApproveBean> =
            ArrayList<ApproveBean>().also {
                it.add(ApproveBean())
                it.add(ApproveBean())
                it.add(ApproveBean())
                it.add(ApproveBean())
                it.add(ApproveBean())
            }
    }
}