package com.elf.vipForElf.domain.area.entity;

import com.elf.vipForElf.domain.area.vo.AreaInfoVO;
import com.elf.vipForElf.domain.floor.entity.FloorEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Entity
@Table(name = "elf_t_area")
@Getter
@Setter
public class AreaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "status", length = 15)
    public String status = "Vacant";

    @Column(name = "office_name", length = 255)
    public String officeName = "-";

    @Column(name = "room_number", length = 10, nullable = false)
    public String roomNumber;

    @Column(name = "area_size", length = 50)
    public String areaSize;

    @Column(name = "move_in_date")
    public OffsetDateTime moveInDate = OffsetDateTime.now();

    @ManyToOne
    @JoinColumn(name = "floor_id", nullable = false)
    public FloorEntity floor;

    public AreaEntity(AreaInfoVO areaInfoVO){
        this.roomNumber = areaInfoVO.getRoomNumber();
        this.areaSize = areaInfoVO.getAreaSize();
        this.floor = areaInfoVO.getFloorEntity();
    }
}
