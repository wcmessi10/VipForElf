package com.elf.vipForElf.floor;

import jakarta.transaction.Transactional;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test") // application-test.yml 사용
@Transactional
public class FloorTest {
}
