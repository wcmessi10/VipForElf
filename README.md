# Elf 프로젝트 - Spring Boot Backend

## 📌 프로젝트 개요
'Elf' 프로젝트의 백엔드 시스템은 Spring Boot를 사용하여 Microservices Architecture(MSA) 기반으로 개발되었습니다. 주요 목표는 엘리베이터의 실시간 위치 및 건물 층별 정보를 제공하는 것입니다.

## 🚀 기술 스택
- **Framework:** Spring Boot 3.4.3 (JPA)
- **Database:** PostgreSQL 16.8
- **Messaging:** MQTT, WebSocket
- **Language:** Java 21
- **Build Tool:** Gradle

## 📂 프로젝트 구조
```
VipForElf
├── .gradle
├── .idea
├── gradle
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.elf.vipForElf
│   │   │       ├── config
│   │   │       ├── domain.test
│   │   │       │   ├── entity
│   │   │       │   │   └── TestEntity.java
│   │   │       │   ├── repository
│   │   │       │   │   ├── JPA
│   │   │       │   │   │   └── TestJPARepository.java
│   │   │       │   │   ├── repositoryImpl
│   │   │       │   │   │   └── TestRepositoryImpl.java
│   │   │       │   │   └── TestRepository.java
│   │   │       │   ├── service
│   │   │       │   │   ├── serviceImpl
│   │   │       │   │   │   └── TestServiceImpl.java
│   │   │       │   │   └── TestService.java
│   │   │       │   ├── vo
│   │   │       │   │   └── TestVO.java
│   │   │       │   ├── web
│   │   │       │   │   ├── controller
│   │   │       │   │   │   └── TestController.java
│   │   │       │   │   └── dto
│   │   │       │   │       └── TestDTO.java
│   │   └── resources
│   │       ├── application.yml     # 환경 설정 파일
│   │       └── static              # 정적 리소스
│   ├── test
│   │   ├── java
│   │   │   └── com.elf.vipForElf
│   │   │       └── VipForElfApplicationTests.java
├── build.gradle
├── gradlew
├── gradlew.bat
├── README.md
└── settings.gradle
```

## 🛠️ 주요 기능
1. **엘리베이터 실시간 위치 조회**
    - WebSocket을 통해 실시간으로 엘리베이터의 위치와 이동 방향을 전송

2. **건물 층별 정보 제공**
    - 특정 층에 입주한 업체 정보 및 운영 시간 제공

## 🔍 API 명세 (준비 중)
현재 API는 준비 중에 있으며, 개발 완료 후 업데이트 예정입니다.

## 🚀 빌드 및 실행 방법
1. **프로젝트 클론**
```bash
git clone http://dev.verywords.com/git/elf-backend.git
cd elf-backend
```

2. **빌드 및 실행**
```bash
./gradlew clean build
java -jar build/libs/elf-backend-0.0.1-SNAPSHOT.jar
```

3. **API 접속 (추후 Swagger 사용 예정)**
- 현재 Swagger는 사용하지 않지만, 나중에 추가될 예정입니다.

## 📄 환경 설정
`application.yml` 예시:
```yaml
server:
  port: 8080
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/elf_db
    username: elf_user
    password: elf_pass
```

## 💡 기여 방법
1. Fork 저장소
2. 기능 개발 및 수정
3. Pull Request 생성

## 📧 문의
- 담당자: 이희두
- 이메일: cjswogmlen@naver.com

