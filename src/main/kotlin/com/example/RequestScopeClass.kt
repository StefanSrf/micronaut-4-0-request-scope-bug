package com.example

import io.micronaut.runtime.http.scope.RequestScope

@RequestScope
class RequestScopeClass(
    // Issue: default value is ignored and as a result type can't be non-null
//    var text: String = "defaultText",
    var text: String?,
    val list: MutableList<String> = mutableListOf()
)
