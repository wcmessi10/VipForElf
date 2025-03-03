package com.elf.vipForElf.domain.test.vo;

import com.elf.vipForElf.domain.test.entity.TestEntity;
import lombok.Value;

@Value
public class TestVO {
    private String id;
    private String test;

    public static TestVO fromEntity(TestEntity entity) {
        return new TestVO(entity.getId(), entity.getTest());
    }
}
