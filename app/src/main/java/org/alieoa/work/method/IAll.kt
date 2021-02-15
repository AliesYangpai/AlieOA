package org.alieoa.work.method

import org.alieoa.work.entity.AllChildBean

interface IAll {
    fun getWorkAll(
        onStart: () -> Unit,
        onSuccess: (ArrayList<AllChildBean>) -> Unit,
        onError: (Int, String) -> Unit,
        onFinish: () -> Unit
    )
}