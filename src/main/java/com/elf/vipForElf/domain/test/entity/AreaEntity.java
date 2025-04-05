package com.elf.vipForElf.domain.test.entity;

import com.elf.vipForElf.domain.test.vo.AreaInfoVO;
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
    private Long id;

    @Column(name = "status", length = 15)
    private String status = "Vacant";

    @Column(name = "office_name", length = 255)
    private String officeName = "-";

    @Column(name = "room_number", length = 10, nullable = false)
    private String roomNumber;

    @Column(name = "area_size", length = 50)
    private String areaSize;

    @Column(name = "move_in_date")
    private OffsetDateTime moveInDate = OffsetDateTime.now();

    @ManyToOne
    @JoinColumn(name = "floor_id", nullable = false)
    private FloorEntity floor;

    public AreaEntity(AreaInfoVO areaInfoVO){
        this.roomNumber = areaInfoVO.getRoomNumber();
        this.areaSize = areaInfoVO.getAreaSize();
        this.floor = areaInfoVO.getFloorEntity();
    }
}
