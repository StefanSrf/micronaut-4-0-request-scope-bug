package com.example

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue

@Controller
class DemoController(
    val requestScopeClass: RequestScopeClass
) {

    @Get("/testEndpoint")
    fun testEndpoint(
        @QueryValue("text") text: String?
    ): HttpResponse<DemoObject> {
        if (text != null) {
            requestScopeClass.text = text
        }
        requestScopeClass.list.add("listEntry")
        val list = requestScopeClass.list
        return HttpResponse.ok(
            DemoObject(
                text = requestScopeClass.text ?: "defaultText",
                list = list
            )
        )
    }
}
