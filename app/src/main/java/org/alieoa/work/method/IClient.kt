package org.alieoa.work.method

import org.alieoa.work.entity.ClientBean

/**
 * 客户类mthdo接口
 */
interface IClient {
    fun getClients(
        onStart: () -> Unit,
        onSuccess: (ArrayList<ClientBean>) -> Unit,
        onError: (Int, String) -> Unit,
        onFinish: () -> Unit
    )
}