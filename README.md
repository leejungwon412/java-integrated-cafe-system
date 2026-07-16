# ☕ java-integrated-cafe-system

> 순수 Java로 구현한 콘솔 기반 카페 관리 시스템

Spring, DB 없이 순수 자바와 파일 입출력만으로 구현한 OOP 연습 프로젝트입니다.
객체지향 설계(상속, 다형성, 역할 분리)를 실전으로 체화하는 것을 목표로 했습니다.

---

## 🛠️ 개발 환경

- Language: Java 17+
- IDE: IntelliJ IDEA
- 버전 관리: Git / GitHub
- 외부 라이브러리: 없음 (순수 Java)

---

## ✅ 구현 기능

### 👤 회원 관리
- 회원가입 (아이디 중복 검사 포함)
- 로그인 / 로그아웃
- 회원 탈퇴 (비밀번호 재확인)

### 🔐 권한 분리
- **관리자**: 메뉴 등록/수정/삭제, 전체 매출 조회
- **일반 사용자**: 메뉴판 조회, 장바구니, 주문/결제, 주문 내역 확인

### 🍽️ 메뉴 관리 (관리자 전용)
- 메뉴 등록
- 메뉴 수정 (상품명 / 가격 / 둘 다)
- 메뉴 삭제 (삭제 확인 절차 포함)

### 🛒 주문 / 결제
- 장바구니 담기 / 조회 / 삭제
- 잔액 기반 결제 (회원가입 시 초기 충전 금액 설정)
- 주문 내역 확인

### 💾 파일 영속화
- 프로그램 종료 시 데이터 파일 저장, 시작 시 불러오기
- `members.txt` / `menus.txt` / `orders.txt`

---

## 📁 프로젝트 구조

```
src/
├── Main.java
├── member/
│   ├── Member.java        ← 회원 부모 클래스
│   ├── Admin.java         ← 관리자 (Member 상속)
│   ├── User.java          ← 일반 사용자 (Member 상속)
│   └── MemberService.java ← 회원 로직 + 파일 저장/불러오기
├── menu/
│   ├── Menu.java          ← 메뉴 객체
│   └── MenuService.java   ← 메뉴 로직 + 파일 저장/불러오기
└── order/
    ├── CartItem.java      ← 장바구니 항목 (Menu + 개수)
    ├── Order.java         ← 주문 객체
    └── OrderService.java  ← 주문/결제 로직 + 파일 저장/불러오기
```

---

## 🏗️ 클래스 구조도

```
Member (부모)
├── Admin  (관리자)
└── User   (일반 사용자)

Menu

CartItem
└── Menu (참조)

Order
└── CartItem (목록)
```

---

## ⚙️ 핵심 설계

### Main은 입출력만, Service는 로직만
사용자 입력을 받고 출력하는 역할은 `Main`이,
실제 데이터 처리는 각 `Service` 클래스가 담당합니다.

### 상속과 다형성으로 권한 분리
`boolean isAdmin` 필드 대신 `Admin`, `User` 클래스를 분리했습니다.
`ArrayList<Member>`에 `Admin`과 `User` 객체를 함께 담고,
`instanceof`로 타입을 확인해 권한에 따라 다른 메뉴를 보여줍니다.

```java
if (memberService.getCurrentMember() instanceof Admin) {
    // 관리자 메뉴
} else {
    // 사용자 메뉴
}
```

### 파일 형식 (쉼표 구분)
```
# members.txt
관리자,ad,ad,1000000000,ADMIN
이정원,ljw,1234,100000,USER

# menus.txt
coffee,2000
ade,3000
cake,5000

# orders.txt
coffee,2
ade,1
```

---

## 🚀 실행 방법

1. 저장소 클론
```bash
git clone https://github.com/leejungwon412/java-integrated-cafe-system.git
```

2. IntelliJ IDEA에서 프로젝트 열기

3. `Main.java` 실행

4. 초기 관리자 계정
    - 아이디: `ad`
    - 비밀번호: `ad`

---

## 📝 관련 글

- [개발 회고 (Velog)](https://velog.io/@leejungwon412/JAVA-java-integrated-cafe-system-%EA%B0%9C%EB%B0%9C-%ED%9A%8C%EA%B3%A0)

---

## 🔮 다음 단계

- 파일 기반 영속화 → DB(JPA + MySQL) 마이그레이션
- Spring Boot 적용