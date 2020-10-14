package org.alieoa.work.universal.logic

class LogicName {
    fun is1WordName(str: String): Boolean = str.length == 1
    fun is2WordName(str: String): Boolean = str.length == 2
    fun is3WordName(str: String): Boolean = str.length == 3

    /**
     * 4个字的名字
     * @param str
     * @return
     */
    fun is4WordName(str: String): Boolean = str.length == 4
    /**
     * 超过个字的名字
     * @param str
     * @return
     */
    fun is4MoreWordName(str: String): Boolean = str.length > 4
}