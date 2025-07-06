package com.elf.vipForElf.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Getter
@NoArgsConstructor
public class ResponseDTO<T> {
    public Boolean result;
    public Long timestamp;
    public T body;

    public ResponseDTO(T body){
        this.result = true;
        this.body = body;
        this.timestamp = Instant.now().toEpochMilli();
    }
}
