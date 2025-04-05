package com.elf.vipForElf.web.controller;

import com.elf.vipForElf.domain.test.service.AreaService;
import com.elf.vipForElf.web.dto.MoveInAreaDTO;
import com.elf.vipForElf.web.dto.NewAreaDTO;
import com.elf.vipForElf.web.dto.ResponseDTO;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/area")
public class AreaController {
    private final AreaService areaService;

    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    @PostMapping("/createArea")
    public ResponseDTO<?> createArea(@ModelAttribute NewAreaDTO newAreaDTO){
        return new ResponseDTO<>(areaService.createArea(newAreaDTO));
    }

    @PostMapping("/moveIn")
    public ResponseDTO<?> moveIn(@ModelAttribute MoveInAreaDTO moveInAreaDTO){
        return new ResponseDTO<>(areaService.moveIn(moveInAreaDTO));
    }
}
