package org.alieoa.work.api

import org.alieoa.work.entity.ClientBean
import retrofit2.http.GET

interface ClientService {
    @GET("alieoa/work/clients")
    fun getClients():List<ClientBean>?
}