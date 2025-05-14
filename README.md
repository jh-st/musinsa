# Musinsa Project

2025 무신사 백엔드 과제

## 📁 사전 요구사항

* 구매 가격 외 추가적인 비용 고려하지 않음
* 브랜드의 카테고리에는 1개의 상품은 존재
* 품절은 없음

## 🛠️ 개발환경

* OpenJDK 11.0.27
* maven 3.6.3
* h2-database

## 🧪 구현기능
* 구현1,2,3 각각의 API
* 상품 등록/수정/삭제 API
* 브랜드 등록/수정/삭제 API
* API 성공 및 실패 시 각 결과에 대한 코드와 사유 리턴

## 📦 프로젝트 클론

```bash
git clone https://github.com/jh-st/musinsa.git
cd musinsa
```

## ⚙️ 빌드

### Maven Wrapper 사용 시

```bash
# Linux / macOS
./mvnw clean install

# Windows
.\mvnw.cmd clean install
```

### Maven 직접 호출 시

```bash
mvn clean install
```

## 🚀 애플리케이션 실행

```bash
# Maven plugin으로 실행
./mvnw spring-boot:run

# 빌드된 JAR 직접 실행
java -jar target/version2-0.0.1-SNAPSHOT.jar
```

## 🔍 API 문서 (Swagger)

애플리케이션 실행 후, 웹 브라우저에서 확인:

```
http://localhost:8080/swagger-ui/index.html
```

## 💡 추가 가이드

* **데이터베이스**: 기본 H2 인메모리(DB 콘솔: `http://localhost:8080/h2-console`, sa)

---

```text
📝 더 자세한 가이드가 필요하면 issues 또는 PR 남겨주세요.
```
