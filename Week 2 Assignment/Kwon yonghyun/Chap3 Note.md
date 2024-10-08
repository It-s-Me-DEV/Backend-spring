
# 스프링 부트 3 구조 이해하기

스프링 부트는 주로 세 가지 계층으로 구성되어 있다: 프레젠테이션(컨트롤러), 비즈니스(서비스), 퍼시스턴스(레포지토리). 이 계층들은 서로 통신하며 프로그램을 구성한다.

## 1. 프레젠테이션 계층

- 주요 역할: HTTP 요청을 받고 이를 비즈니스 계층으로 전송하는 것이다.
- 구성 요소: 컨트롤러이다.
- 설명: 프레젠테이션 계층은 주로 컨트롤러로 구현되며, 외부 요청을 처리하고 적절한 비즈니스 로직으로 연결하는 역할을 한다.

## 2. 비즈니스 계층

- 주요 역할: 비즈니스 로직을 처리하는 것이다.
- 구성 요소: 서비스이다.
- 설명: 비즈니스 계층은 애플리케이션의 핵심 로직을 담당한다. 여기에는 주요 비즈니스 프로세스뿐만 아니라 예외 처리 로직도 포함된다.

## 3. 퍼시스턴스 계층

- 주요 역할: 데이터베이스 관련 로직을 처리하는 것이다.
- 구성 요소: 레포지토리이다.
- 설명: 퍼시스턴스 계층은 데이터의 영속성을 관리한다. 데이터베이스와의 모든 상호작용, 즉 데이터의 생성, 읽기, 갱신, 삭제(CRUD) 작업을 담당한다.

이 세 계층은 상호 작용하며 스프링 부트 애플리케이션의 전체 구조를 형성한다. 각 계층은 특정 책임을 가지고 있어, 코드의 구조화와 유지보수를 용이하게 만든다.
