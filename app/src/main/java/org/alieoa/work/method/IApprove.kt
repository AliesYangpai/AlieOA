package org.alieoa.work.method

import org.alieoa.work.entity.ApproveBean


interface IApprove {
    fun getApproves(
        onStart: () -> Unit,
        onBeforeFinish: () -> Unit,
        onSuccess: (ArrayList<ApproveBean>) -> Unit,
        onError: (Int, String) -> Unit,
        onFinish: () -> Unit
    )
}