### 03장 스프링 부트 3 구조 이해하기
 # 스프링 부트 3 구조
   스프링 부트는 각 계층이 양 옆의 계층과 통신하는 구조를 가짐
   예: 웹 브라우저 요청 → TestController → TestService → MemberRepository (DB와 연결)
 # 계층
   프레젠테이션 계층: HTTP 요청을 받고 비즈니스 계층으로 전달. 예: TestController 클래스
   비즈니스 계층: 주로 비즈니스 로직을 처리하는 부분. 예: TestService 클래스
   퍼시스턴스 계층: 데이터베이스와 소통하는 계층. 예: MemberRepository 클래스
 # 스프링 부트 디렉터리 구성
   main: 코드와 리소스 파일
   test: 테스트용 코드
   build.gradle: 빌드에 필요한 의존성, 플러그인 설정
   settings.gradle: 빌드할 프로젝트의 정보 설정
   application.yml: 스프링 부트 설정, 데이터베이스, 로깅 정보 등