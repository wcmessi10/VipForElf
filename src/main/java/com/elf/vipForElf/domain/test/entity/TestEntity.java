package com.elf.vipForElf.domain.test.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "elf_t_test")
@Getter
@Setter
public class TestEntity {
    @Id
    private String id;
    private String test;
}
