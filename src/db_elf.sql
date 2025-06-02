-- 건물 테이블
CREATE TABLE if not exists elf_t_building (
    id SERIAL PRIMARY KEY,
    building_name VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    building_number VARCHAR(10),
    business_number VARCHAR(50),
    zipcode VARCHAR(5),
    create_date TIMESTAMP WITH TIME ZONE DEFAULT now()
);

create index if not exists idx_building_name on elf_t_building(building_name);

COMMENT ON table elf_t_building IS '건물 정보를 저장하는 테이블';
COMMENT ON COLUMN elf_t_building.id IS '건물 ID (자동 증가)';
COMMENT ON COLUMN elf_t_building.building_name IS '건물명';
comment on column elf_t_building.building_number is '건물번호(본번, 부번 포함)';
COMMENT ON COLUMN elf_t_building.address IS '건물 주소';
comment on column elf_t_building.zipcode is '우편번호';
COMMENT ON COLUMN elf_t_building.business_number IS '사업자 번호';
comment on column elf_t_building.create_date is '건축 일자';


-- 층 테이블 (건물과의 외래키 관계 설정)
CREATE TABLE if not exists elf_t_floor (
    id SERIAL PRIMARY KEY,
    floor_number INTEGER NOT NULL,
    purpose VARCHAR(255) default 'Mixed-use',
    building_id INTEGER NOT NULL,
    CONSTRAINT fk_building
      FOREIGN KEY (building_id) REFERENCES elf_t_building (id)
      ON DELETE CASCADE
);

-- 층 테이블에 대한 설명 추가
COMMENT ON TABLE elf_t_floor IS '건물의 각 층 정보를 저장하는 테이블';
COMMENT ON COLUMN elf_t_floor.id IS '층 ID (자동 증가)';
COMMENT ON COLUMN elf_t_floor.floor_number IS '몇 층';
COMMENT ON COLUMN elf_t_floor.purpose IS '층의 용도 (default : Mixed-use(다용도))';
COMMENT ON COLUMN elf_t_floor.building_id IS '연관 건물 ID';

-- 영역(호) 테이블 (층과의 외래키 관계 설정)
CREATE TABLE if not exists elf_t_area (
    id SERIAL PRIMARY KEY,
    status VARCHAR(15) default 'Vacant',
    office_name VARCHAR(255) default '-',
    room_number VARCHAR(10) not NULL,
    area_size VARCHAR(50),
    move_in_date TIMESTAMP WITH TIME ZONE DEFAULT now(),
    floor_id INTEGER NOT NULL,
    CONSTRAINT fk_floor
      FOREIGN KEY (floor_id) REFERENCES elf_t_floor (id)
      ON DELETE CASCADE
);

-- 영역 테이블에 대한 설명 추가
COMMENT ON TABLE elf_t_area IS '층의 각 영역 정보를 저장하는 테이블';
COMMENT ON COLUMN elf_t_area.status is '현재 상태 (Occupied : 입주, Vacant(default) : 미입주)';
COMMENT ON COLUMN elf_t_area.id IS '영역 ID (자동 증가)';
COMMENT ON COLUMN elf_t_area.office_name IS '입주사 명(default : -)';
comment on column elf_t_area.move_in_date is '입주 일자(default : 오늘)';
COMMENT ON COLUMN elf_t_area.area_size IS '면적 정보';
COMMENT ON COLUMN elf_t_area.floor_id IS '연관 층 ID(foreign key)';
COMMENT ON COLUMN elf_t_area.room_number is '호실';


-- 입주 이력 테이블: 해당 영역의 입주 관련 변경 이력을 저장 (삭제되지 않고 계속 누적)
CREATE TABLE IF NOT EXISTS elf_t_move_in_history (
    id SERIAL PRIMARY KEY,                            -- 입주 이력 ID (자동 증가)
    area_id INTEGER NOT NULL,                         -- 연관된 영역(호) ID
    move_in_date TIMESTAMP WITH TIME ZONE DEFAULT now(), -- 입주 일자 (기본값: 현재 시간)
    status VARCHAR(15) NOT NULL,                      -- 입주 상태 (예: Occupied, Vacant)
    office_name VARCHAR(255) DEFAULT '-',             -- 입주사 명 (기본값: '-')
    created_at TIMESTAMP WITH TIME ZONE DEFAULT now(), -- 기록 생성 일자
    note TEXT                                         -- 추가 비고 또는 변경 사항에 대한 설명
);

-- 입주 이력 테이블에 대한 주석 추가
COMMENT ON TABLE elf_t_move_in_history IS '입주 이력을 저장하는 테이블 (삭제되지 않고 누적됨)';
COMMENT ON COLUMN elf_t_move_in_history.id IS '입주 이력 ID (자동 증가)';
COMMENT ON COLUMN elf_t_move_in_history.area_id IS '연관된 영역(호) ID';
COMMENT ON COLUMN elf_t_move_in_history.move_in_date IS '입주 일자 (변경 시 기록됨)';
COMMENT ON COLUMN elf_t_move_in_history.status IS '입주 상태 (Occupied: 입주, Vacant: 미입주 등)';
COMMENT ON COLUMN elf_t_move_in_history.office_name IS '입주사 명 (해당 시)';
COMMENT ON COLUMN elf_t_move_in_history.created_at IS '기록 생성 일자';
COMMENT ON COLUMN elf_t_move_in_history.note IS '추가 비고 또는 변경 사항 설명';

-- elf_t_move_in_history 테이블의 area_id 컬럼에 대한 외래 키 제약조건 추가
ALTER TABLE elf_t_move_in_history
ADD CONSTRAINT fk_area_history
FOREIGN KEY (area_id) REFERENCES elf_t_area(id);

-- elf_t_real_estate_agency 부동산 테이블 추가
create table if not exists elf_t_real_estate_agency(
	id SERIAL primary key,						  		-- 중개사 id (자동 증가)
	real_estate_agency_name varchar(30) not null, 		-- 중개사 이름
	regist_dt TIMESTAMP with TIME zone default now(), 	-- 중개사 등록 일자
	contact VARCHAR(15) not null,						-- 중개사 연락처
	description VARCHAR(1000) not null					-- 중개사 설명
);

comment on table elf_t_real_estate_agency is '부동산 테이블';
comment on column elf_t_real_estate_agency.id is '중개사 id (자동 증가)';
comment on column elf_t_real_estate_agency.real_estate_agency_name is '중개사 이름';
comment on column elf_t_real_estate_agency.regist_dt is '중개사 등록 일자';
comment on column elf_t_real_estate_agency.contact is '중개사 연락처';
comment on column elf_t_real_estate_agency.description is '중개사 설명';


create table if not exists elf_t_real_estate_listing(
	id SERIAL primary key,						-- 매물 리스트 id
	listing_type varchar(10) not null,			-- 매물 타입(건물 or 공간)
	listing_id Integer not null,				-- 매물 id (건물이면 건물 id, 공간이면 공간 id)
	occupancy_type varchar(15) not null,			-- 계약 타입코드(임대차 계약, 공유 오피스, 사무실 분양)
	sale_price     NUMERIC(15, 2) default null, -- 사무실 분양가
	deposit        NUMERIC(15, 2) default null, -- 임대차 보증금
	monthly_rent   NUMERIC(15, 2) default null, -- 월세 또는 공유오피스 요금
	status varchar(20) default 'REGIST',		-- 매물 상태값(등록, 완료, 취소 등)
	real_estate_agency_id Integer not null,		-- 중개사 id
	constraint fk_real_estate_agency
	foreign key (real_estate_agency_id) references elf_t_real_estate_agency (id)
	on delete cascade
);

comment on table elf_t_real_estate_listing is '부동산 매물';
comment on column elf_t_real_estate_listing.id is '매물 리스트 id';
comment on column elf_t_real_estate_listing.listing_type is '매물 타입(건물 or 공간)';
comment on column elf_t_real_estate_listing.listing_id is '매물 id (건물이면 건물 id, 공간이면 공간 id)';
comment on column elf_t_real_estate_listing.occupancy_type is '계약 타입코드(임대차 계약, 공유 오피스, 사무실 분양)';
comment on column elf_t_real_estate_listing.sale_price is '사무실 분양가';
comment on column elf_t_real_estate_listing.deposit is '임대차 보증금';
comment on column elf_t_real_estate_listing.monthly_rent is '월세 또는 공유오피스 요금';
comment on column elf_t_real_estate_listing.status is '매물 상태값(등록, 완료, 취소 등)';
comment on column elf_t_real_estate_listing.real_estate_agency_id is '중개사 id';

alter table elf_t_real_estate_listing add column listing_name VARCHAR(50);

CREATE TABLE elf_t_contract (
    contract_id BIGSERIAL PRIMARY KEY,

    real_estate_agency_id BIGINT NOT NULL,
    land_lord_id VARCHAR(255),
    real_estate_listing_id BIGINT,

    contract_pdf_link TEXT,
    contract_status VARCHAR(50),

    regist_dt TIMESTAMP,
    last_update_dt TIMESTAMP,
    move_in_dt TIMESTAMP,

    CONSTRAINT fk_real_estate_agency
        FOREIGN KEY (real_estate_agency_id)
        REFERENCES elf_t_real_estate_agency (id),

    CONSTRAINT fk_real_estate_listing
        FOREIGN KEY (real_estate_listing_id)
        REFERENCES elf_t_real_estate_listing (id)
);

comment on table elf_t_contract is '부동산 계약';
comment on column elf_t_contract.contract_id is '계약 id';
comment on column elf_t_contract.real_estate_agency_id is '계약 담당 중개사 id';
comment on column elf_t_contract.land_lord_id is '임대인 id';
comment on column elf_t_contract.real_estate_listing_id is '매물 id';
comment on column elf_t_contract.contract_pdf_link is '계약서 PDF 파일 링크';
comment on column elf_t_contract.contract_status is '계약서 상태값(계약 등록, 임대인 확인, 임대인에 의한 계약 취소, 입주자에 의한 계약 취소, 계약 합의';
comment on column elf_t_contract.regist_dt is '계약 신청일자(해당 row 생성일자)';
comment on column elf_t_contract.last_update_dt is '계약 최근 업데이트 일자';
comment on column elf_t_contract.move_in_dt is '입주 일자';