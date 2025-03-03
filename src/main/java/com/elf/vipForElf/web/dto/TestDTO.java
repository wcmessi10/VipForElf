package com.elf.vipForElf.web.dto;

import com.elf.vipForElf.domain.test.entity.TestEntity;
import com.elf.vipForElf.domain.test.vo.TestVO;

public class TestDTO {
    private String id;
    private String test;

    public TestDTO(String id, String test) {
    }

    public TestDTO(TestVO testVO) {
        this.id = testVO.getId();
        this.test = testVO.getTest();
    }

    public String getId() {
        return id;
    }

    public String getTest() {
        return test;
    }
}
