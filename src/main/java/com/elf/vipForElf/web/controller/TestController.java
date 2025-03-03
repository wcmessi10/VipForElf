package com.elf.vipForElf.web.controller;

import com.elf.vipForElf.domain.test.service.TestService;
import com.elf.vipForElf.web.dto.TestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/get")
    public ResponseEntity<TestDTO> getTest(@RequestParam String id){
        TestDTO testDTO = testService.getById(id);
        return ResponseEntity.ok(testDTO);
    }
}
