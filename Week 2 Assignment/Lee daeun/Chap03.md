## ✍️Chap03. 스프링 부트3 구조 이해하기

### 👉 스프링 부트 애플리케이션 구조
> 1. 웹 브라우저가 클래스에 요청
> 2. TestController 클래스에서 요청을 받아 분기 처리하여 어떤 요청인지 판단
> 3. TestService 클래스가 요청에 맞는 작업을 실행
> 4. Member 클래스로 구현한 클래스를 MemberRepository 클래스가 실제 테이블과 연결

### 👉 스프링 부트 애플리케이션 구조
: 스프링 부트는 각 계층이 양 옆의 계층과 통신하는 구조를 가진다. 즉 각 계층은 서로 통신할 수는 있지만 다른 계층에 직접 간섭하거나 영향을 미치지 않음. 스프링 부트에는 프레젠테이션, 비즈니스, 퍼시스턴스 계층이 있으며 계층은 서로 통신한다.
> 프레젠테이션 계층(컨트롤러), 비즈니스 계층(서비스), 퍼시스턴스 계층(리포지토리), 데이터베이스

### 👉 프레젠테이션 계층
: HTTP 요청을 받고 비즈니스 계층으로 전송하며 TestController 클래스가 예

### 👉 비즈니스 계층
: 비즈니스는 로직을 처리한다. 이때 비즈니스 로직이란 프로세스를 구현하기 위한 로직으로 서비스가 예

### 👉 퍼시스턴스 계층
: 데이터베이스 관련 로직으로 DAO는 데이터베이스 계층과 상호작용하기 위한 객체이다.

### 👉 스프링 부트 프로젝트 디렉터리 구성
> /src/main : 실제 코드를 작성하는 곳, 프로젝트 실행에 필요한 소스 코드나 리소스 파일
  - /src/main/resources/templates : HTML과 같은 뷰 관련 파일
  - /src/main/resources/static : JS, CSS 정적 파일
  - /src/main/resources/application.yaml : 스프링 부트 서버가 실행되면 자동으로 로딩되는 파일       
> /src/test : 프로젝트의 소스 코드를 테스트할 목적의 코드, 리소스 파일
> /src/build.gradle : 빌드를 설정하는 파일, 의존성이나 플러그인 설정과 같이 빌드에 필요한 설정
> /src/settings.gradle : 빌드할 프로젝트 관련 정보 설정

### 👉 스프링 부트 3 프로젝트 발전시키기 
1. build.gralde에 의존성 추가하기
<img width="684" alt="스크린샷 2024-09-18 오후 11 32 31" src="https://github.com/user-attachments/assets/5b298f55-0908-409e-a43a-04d198f1c5e6">

2. 프레젠테이션, 서비스, 퍼시스턴스 계층 만들기
<img width="580" alt="스크린샷 2024-09-18 오후 11 42 00" src="https://github.com/user-attachments/assets/37611573-e52f-4f62-a998-e5b8dbe76c84">
<img width="530" alt="스크린샷 2024-09-18 오후 11 45 11" src="https://github.com/user-attachments/assets/a16019a8-006f-4ce6-be17-a883586e6208">
<img width="587" alt="스크린샷 2024-09-18 오후 11 46 57" src="https://github.com/user-attachments/assets/bc8dc2ef-818a-45ec-98dd-30b1dfd2f238">

### 👉 스프링 부트 3 프로젝트 작동 확인하기
1. 데이터 넣기
<img width="585" alt="스크린샷 2024-09-19 오전 12 04 20" src="https://github.com/user-attachments/assets/32df1cac-b853-488e-a7a4-fd45a65900ac">

2. application.yml 수정
<img width="464" alt="스크린샷 2024-09-19 오전 12 05 25" src="https://github.com/user-attachments/assets/a5a99d20-37b7-426b-a012-04d6d064927b">

3. CREATE TABLE 만들어졌는지 확인
4. HTTP 요청 확인
5. 
