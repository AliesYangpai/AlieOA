package org.alieoa.work.method

import org.alieoa.work.entity.AnnounceBean

/**
 * 获取全部公告的接口
 */
interface IAnnounce {
    fun getAnnounces(
        onStart: () -> Unit,
        onSuccess: (ArrayList<AnnounceBean>) -> Unit,
        onError: (Int, String) -> Unit,
        onFinish: () -> Unit)
}