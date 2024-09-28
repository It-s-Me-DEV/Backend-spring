## Chap07. 블로그 화면 구성하기
### 7.1). 타임리프란?
: 타임리프는 템플릿 엔진으로 스프링 서버에서 데이터를 받아 우리가 보는 웹 페이지에 그 데이터를 넣어서 보여주는 도구
즉 HTML 상에 그 데이터를 넣어 보여주는 도구로 대표적으로는 JSP, 타임리프, 프리마커 등이 있다.

**타임리프 표현식**
>${...}: 변수의 값 표현식

>#{...}: 속성 파일 값 표현식

>@{...}: URL 표현식

>*{...}: 선택한 변수의 표현식, th:object에서 선택한 객체에 접근

**타임리프 문법**
> th:text 텍스트를 표현할 때 사용

> th:each 컬렉션을 반복할 때 사용

> th:if 조건이 true인 때만 표시

> th:unless 조건이 false인 때만 표시

> th:href 이동 경로

> th:with 변숫값으로 지정

> th:object 선택한 객체로 지정

**타임리프를 사용하기 위해 build.gradle 파일에 의존성 "implemetation 'org.springframework.boot:spring-boot-starter-thymeleaf'를 추가한다**

### controller 패키지에 ExampleController.java 파일 추가
<img width="734" alt="스크린샷 2024-09-28 오후 2 08 02" src="https://github.com/user-attachments/assets/f3e12d31-daf9-458a-861d-3407a7c2ddbf">

- Model 모델 객체는 뷰, 즉 HTML에 값을 넘겨주는 객체이다.
- addAttribute() 메서드로 모델에 값을 저장한다.
- thymeleafExample() 메서드가 반환하는 값은 "example"이다.
- 클래스에 붙은 애너테이션 @Controller이므로 뷰의 이름을 반환한다.
- resource/templates 디렉터리에서 example.html을 찾은 다음 웹 브라우저에 해당 파일을 보여준다

### 모델의 역할(중간다리의 역할)
1. person
2. today
** 컨드롤러는 이렇게 모델을 통해 데이터를 설정하고 뷰로 이 데이터를 전달해 키에 맞는 데이터를 뷰에서 조회하게 해준다

### 뷰 작성하기
<img width="597" alt="스크린샷 2024-09-28 오후 2 23 41" src="https://github.com/user-attachments/assets/7bbc323b-3b77-4eb3-9418-8694b0a7891d">
- temporals.format() 함수로 LocalDate 타입을 yyyy-MM-dd 형식으로 포매팅한다.
- th:object를 사용해 모델에서 받은 객체 중 "person"이라는 키워드 객체의 데이터를 하위 태그에 지정
- *{...}를 사용해 부모 태그에 적용한 객체 값에 접근 할 수 있다.
- th:text를 사용해 텍스트를 표현

<img width="562" alt="스크린샷 2024-09-28 오후 2 33 42" src="https://github.com/user-attachments/assets/19f817a8-5a81-408a-9401-f2d2ddedb196">

다음과 같이 프론트 화면이 뜬다.

<img width="325" alt="스크린샷 2024-09-28 오후 2 34 33" src="https://github.com/user-attachments/assets/a6b8ce4f-ae1a-49bb-a6a6-2c74cf8f90ba">


### 컨트롤러 메서드 작성하기
<img width="611" alt="스크린샷 2024-09-28 오후 2 41 11" src="https://github.com/user-attachments/assets/51775b55-fd2f-491c-ac1e-8cd1a4403383">

<img width="749" alt="스크린샷 2024-09-28 오후 2 47 00" src="https://github.com/user-attachments/assets/a93c44d3-a3d9-4c64-abec-a18a4c3fa6b1">

### articleList.html
resource/templates 디렉터리에 aricleList.html을 만들고 모델에 전달한 블로그 글 리스트 개수만큼 반복해 글 정보를 보여준다.
