package com.elf.vipForElf.web.dto

import java.time.Instant

data class ResponseDTO<T>(
    var result: Boolean = true,
    var timestamp: Long = Instant.now().toEpochMilli(),
    var body: T? = null
){
    constructor(body: T) : this(
        result = true,
        timestamp = Instant.now().toEpochMilli(),
        body = body
    )
}