package com.elf.vipForElf.domain.moveInHistory.entity;

import com.elf.vipForElf.domain.area.entity.AreaEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Entity
@Table(name = "")
@Getter
@Setter
public class MoveInHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 연관된 영역(호)와의 관계를 ManyToOne으로 매핑 (외래 키가 area_id)
    @ManyToOne
    @JoinColumn(name = "area_id", nullable = false)
    private AreaEntity area;  // Area 엔티티가 미리 정의되어 있어야 합니다.

    @Column(name = "move_in_date")
    private OffsetDateTime moveInDate = OffsetDateTime.now();

    @Column(name = "status", length = 15, nullable = false)
    private String status;

    @Column(name = "office_name", length = 255)
    private String officeName = "-";

    @Column(name = "created_at")
    private OffsetDateTime createdAt = OffsetDateTime.now();

    @Column(name = "note", columnDefinition = "TEXT")
    private String note;
}
