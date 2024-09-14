### 2장 스프링 부트 3 시작하기

# 2.1 스프링과 스프링부트
- 스프링 프레임워크를 통해 서버 성능, 안정성, 보안을 제공받고 기능 개발에만 집중
- 스프링 부트: 스프링 쉽게 사용할 수 있도록 빠르게 스프링 프로젝트
		    WAS가 내장되어 있음 / 스프링 부트 스타터 -> 빌드 구성 단순화 / 개발 환경 자동 / XML X

# 2.2 스프링 콘셉트 공부하기
- IoC(Inversion of Control): 제어의 역전 -> 클래스 객체 직접 생성 X 어디선가 받아온 객체를 할당함
- DI(Depedency Injection): 의존성 주입 -> 애너테이션 통해 객체(빈) 주입
- 스프링 컨테이너: 빈(=스프링 컨테이너에서 관리하는 객체) 생성 및 관리
- 빈: 다양한 방법으로 등록 가능 ex) 클래스에 애너테이션 추가 -> 클래스 이름의 첫 글자 소문자로 한 이름
- AOP(Aspect Oriented Programming): 관점 지향 프로그래밍 -> 핵심 관점 + 부가 관점 나누어서 모듈화 => 이를 통해 핵심 관점 코드에만 집중 가능 및 변경, 확장에 유연 대응 가능
-PSA(Portable Service Abstraction): 이식 가능한 서비스 추상화 -> 어떤 기술이든 일관된 방식으로 일을 처리

# 2.3 스프링 부트 3 둘러보기
- @SpringBootApplication : main(), 스프링 부트 시작 -> SpringApplication.run() 메소드로 애플리케이션 실행
- @SpringBootConfiguration
- @ComponentScan : @Component 가진 클래스들을 빈으로 등록 + 컴포넌트 포함하는 아래의 애너테이션
	@Configuration : 설정 파일 등록
	@Repository : ORM 매핑
	@Controller, @RestController : 라우터 -> HTTP 요청과 메소드 연결 장치
	@Service : 비즈니스 로직
