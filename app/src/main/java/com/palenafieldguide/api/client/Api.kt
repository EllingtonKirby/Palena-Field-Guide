package com.palenafieldguide.api.client

import retrofit2.http.GET


interface Api {

    @GET() fun get()
}