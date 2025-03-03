package com.elf.vipForElf.domain.test.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "elf_t_test")
@Getter
@Setter
public class TestEntity {
    @Id
    private String id;
    private String test;
}
