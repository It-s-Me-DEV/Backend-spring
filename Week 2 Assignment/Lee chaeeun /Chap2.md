# 2.1 스프링과 스프링 부트


스프링을 더 쉽게 만들어주는 스프링 부트

스프링은 장점이 많은 개발 도구이지만 설정이 매우 복잡하다는 단점이 있다.

이런 단점을 보완하고자 스프링 부트가 나왔다.



## 스프링 부트란?
스프링 프레임워크를 더 쉽고 빠르게 이용할 수 있도록 만들어주는 도구이다.

빠르게 스프링 프로젝트를 설정할 수 있고 의존성 세트라고 불리는 스타터를 사용해 간편하게 의존성을 사용하거나 관리할 수 있다.



1. 톰캣(Tomcat) , 제티(Jetty), 언더토우(Undertow) 같은 웹 애플리케이션 서버(wed application server, WAS)가 내장되어 있어서 따로 설치하지 않아도 독립적으로 실행이 가능하다. (Tomcat은 기본 값)

2. 빌드 구성을 단순화하는 스프링 부트 스타터를 제공한다.

3. XML 설정을 하지 않고 자바  코드로 모두 작성할 수 있다.

4. JAR을 이용해서 자바 옵션만으로도 배포가 가능하다.

5. 애플리케이션의 모니터링 및 관리 도구인 스프링 액츄에이터(spring actuator)를 제공한다. 



스프링 부트는 스프링에 속한 도구이다!! 



차이점1. 구성의 차이

스프링은 애플리케이션 개발에 필요한 환경을 수동으로 구성하고 정의해야 한다. 

하지만 스프링 부트는 스프링 코어와 스프링 MVC의 모든 기능을 자동으로 로드하므로 수동으로 개발 환경을 구성할 필요가 없다.



차이점2. 내장 WAS의 유무

스프링 애플리케이션은 일반적으로 톰캣과 같은 WAS(Wed Server Application, WAS)에서 배포된다. 

하지만 스프링 부트는 WAS를 자체적으로 가지고 있다. 그래서 JAR 파일만 만들면 별도로 WAS를 설정하지 않아도 애플리케이션을 실행할 수 있다.



# 2.2 스프링 콘셉트 공부하기

## 💡스프링 콘셉트 알아보기

#### - 제어의 역전(IoC)

#### - 의존성 주입(DI)

#### - 스프링 컨테이너와 빈이 무엇인지

#### - 관점 지향 프로그래밍(AOP)

#### - 이식 가능한 서비스 추상화(PSA)



🔍 제어의 역전(IoC)과 의존성 주입(DI)

스프링은 모든 기능의 기반을 제어의 역전과, 의존성 주입에 두고 있다.



### 제어의 역전(IoC) = Inversion of Control




클래스 B 객체를 사용하기 위해 클래스 A에서 객체를 직접 생성한다.


제어의 역전은 다른 객체를 직접 생성하거나 제어하는 것이 아니라 외부에서 관리하는 객체를 가져와 사용하는 것을 말한다.



위 예제에 제어의 역전을 적용하면 다음과 같은 코드 형태로 바뀌게 된다.


이전과 다르게 클래스 B 객체를 직접 생성하지 않는다.


스프링에서는 객체들을 관리하기 위해 제어의 역전을 사용한다.



### DI(Dependency Injection, 의존성 주입)란?



위에서 설명했던 제어의 역전을 구현하기 위해 DI를 사용한다.

DI는 어떤 클래스가 다른 클래스에 의존한다는 뜻이다.






-> 스프링 컨테이너가 B 객체를 만들어서 클래스 A에게 준 것이다. 



위 코드에서 @Autowired라는 애너테이션은 스프링 컨테이너에 있는 빈이라는 것을 주입하는 역할을 한다.

빈은 쉽게 말해 스프링 컨테이너에서 관리하는 객체를 말한다. 


스프링 컨테이너가 B 객체를 만들어 클래스 A에게 전달한다.




위 첫번째 코드는 클래스 A에서 B 객체를 쓰고 싶은 경우 직접 생성했지만, 

두번째 코드(스프링의 경우)는 객체를 직접 생성하는 것이 아니라 스프링 컨테이너에서 객체를 주입받아 사용한다.



이 IoC/DI 개념은 스프링의 핵심 개념이다!



### 🔍 빈과 스프링 컨테이너란?


스프링은 스프링 컨테이너를 제공한다.

스프링 컨테이너는 빈을 생성하고 관리한다. 빈이 생성되고 소멸되기까지의 생명주기를 이 스프링 컨테이너가 관리하는 것이다.

개발자가 @Autowired 같은 애너테이션을 사용해 빈을 주입받을 수 있게 DI를 지원한다.





빈은 스프링 컨테이너가 생성하고 관리하는 객체이다. 




위 코드에서 B가 바로 빈이다. 

스프링이 빈을 스프링 컨테이너에 등록하는 방법에는 여러 가지가 있다.

예를 들어,

Mybean이라는 클래스에 @Component 애너테이션을 붙이면 Mybean 클래스가 빈으로 등록이 된다.

이때 빈의 이름은 클래스 이름의 첫 글자를 소문자로 바꿔서 관리한다.

MyBean 클래스의 빈 이름은 myBean이다.



### 🔍 관점 지향 프로그래밍(AOP)이란?
AOP = Aspect Oriented Programming



AOP는 OOP를 대신하는 개념이 아니라, 기존 OOP를 더욱 보완, 확장한 것이다. 



조금 쉽게 말하자면, 

프로그래밍에 대한 관점을 핵심 관점, 부가 관점으로 나누어서 관심 기준으로 모듈화하는 것을 말한다. 

그래서 AOP를 사용하면 애플리케이션의 핵심 비즈니스 로직관 관련 없는 부가적인 기능들을 모듈화하여 코드의 중복을 줄이고 유지보수성을 향상시킬 수 있다. 



Spring에서는 일반적으로 사용하는 클래스에서 중복되는 공통 코드 부분(commit, rollback, log처리)을 별도의 영역으로 분리하고, 코드가 시행 되기 전이나 이 후의 시점에 해당 코드를 붙여 넣음으로써 소스 코드의 중복을 줄이고, 필요할 때 마다 가져다 쓸 수 있게 하는 기술이다. 




위 그림에서 처럼 계좌이체, 입출금, 이자계산이라는 로직을 처리할 때 모두 똑같이 로깅, 보안, 트랜잭션을 처리해줘야하고 따라서 모든 로직에 똑같은 코드가 반복적으로 삽입될 수 밖에 없다.



AOP에서는 로깅, 보안, 트랜잭션이라는 공통 관심(Aspect)를 따로 빼내어 계좌이체, 입출금, 이자계산이라는 핵심 관심에 횡단으로 삽입해주는 것이다. 

이로써 계좌이체, 입출금, 이자계산과 같은 핵심 기능을 만들고 공통적인 관심 기능(로깅, 보안, 트랜잭션)을 처리하는 모듈을 분리해서 개발한 후, 필요한 시점에 자동으로 공통적인 관심 기능이 삽입되도록 한다.



### 🔍 이식 가능한 서비스 추상화(PSA)


PSA = Portable Service Abstraction



먼저 서비스 추상화란 무엇일까?

특정 서비스가  추상화되어있다는 것은 서비스 내용을 모르더라도 해당 서비스를 이용할 수 있다는 것을 의미한다.



예를 들어, JDBC Driver를 사용해 데이터베이스에 접근하지만 JDBC Driver가 어떻게 구현되어 있는지는 관심이 없다.

실제 구현부를 추상화 계층으로 숨기고 핵심적인 요소만 개발자에게 제공함으로써 실제 구현부를 모르더라도 해당 서비스를 이용할 수 있도록 하는 것이다. 



여기에 Portable이 붙는다면?



Portable은 JDBC Driver의 종류를 비즈니스 로직의 수정없이 언제든지 변경할 수 있는 것을 말한다. 

예를 들어, MySQL Driver를 사용하다가 어느 순간 Oracle Driver로 변경한다고 해서 프로젝트의 비즈니스 로직에 변화가 생기지 않는다는 것이다. 



이러한 것은 추상화 계층이 존재하기 때문에 가능한 것이다.

모든 JDBC Driver는 공통적인 인터페이스를 가지고 있기 때문에 해당 인터페이스를 구현하는 어떤 것으로 대체되든 프로젝트에 영향이 없어진다. 



따라서 PSA는

1. 서비스를 추상화함으로써 개발자가 실제 구현부를 알지 못하더라도 해당 가능을 사용할 수 있게 된다.

2. PSA는 해당 추상화 계층을 구현하는 또 다른 서비스로 언제든지 교체할 수 있게 한다. 



예를 들어 @Cacheable 애노테이션을 보자. 

비즈니스 로직의 특정 메서드의 결과를 캐싱하고 싶을 때 @Cacheablee 애노테이션을 사용한다.

현재 EhCache를 사용해 로컬 캐시를 사용하고 있다고 했을 때 이를 Redis로 바꾸고 싶다.

그럼 해당 비즈니스 로직을 모두 수정해야 할까?



아니다!

단순히 CacheManager만 EhCacheManager에서 RedisCacheManager로 교체해주면 된다.



이와 같이 비즈니스 로직 수정없이 다른 서비스로 교체 가능한 이유는 PSA에 있다.



Spring은 Spring Web MVC, Spring Transaction, Spring Cache 등의 다양한 PSA를 제공한다.



Spring PSA는 추상화 계층을 추가해 서비스를 추상화하고 여러 서비스를 비즈니스 로직을 수정하지 않고 교체할 수 있도록 하는 것을 의미한다.






추상화 계층의 인터페이스인 Platform TransactionManager 인터페이스




위의 그림은 추상화 계층의 인터페이스인 Platform TransactionManager 인터페이스를 두고 이를 구현하는 다양한 비즈니스 로직을 추상화 한 것이다. 개발자는 단순히 Platform TransactionManager를 선언해 이용하면 되고 언제든지 이를 구현하는 다른 구현체로 변경이 가능하다.



예를 들어 JDBC를 사용하는 DatasourceTransactionManager, JPA를 사용하는 JPATransactionManager, Hibernate를 사용하는 HibernateTransactionManager를 유연하게 바꿔서 사용할 수 있다. 






# 2.3 스프링 부트 3 둘러보기

이 코드는 사용자가 /test GET 요청을 하면 "Hello, world!" 문자열을 반환하게 해준다. 

package me.shinsunyoung.springbootdeveloper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test")
    public String test(){
     return"Hello, world!";
   }
}




웹 브라우저에 http://localhost:8080/test로 접속하면 화면에 지정한 문자열이 출력이 된다. 




http://localhost:8080/test 


localhost는 아이피로 127.0.0.1이다. 

localhost는 현재 사용중인 컴퓨터,

8080은 스프링 부트의 포트 번호,

/test는 코드에서 @GetMapping이라는 애너테이션으로 메서드와 매핑할 때 스프링 부트에서 설정한 경로이다. 



스프링 부트 스타터


스프링 부트 스타터는 의존성이 모여 있는 그룹이다. 

스타터를 사용하면 필요한 기능을 간편하게 설정할 수 있다. 

스타터는 spring-boot-starter-{작업유형}이라는 명명규칙이 있다. 

그래서 예를 들어, jdbc 관련 스타터는 spring-boot-starter-jdbc이다. 



스타터 	설명
spring-boot-starter-web	Spring MVC를 사용해 Restful 웹 서비스를 개발 할 때 필요한 의존성 모음
spring-boot-starter-test	스프링 애플리케이션을 테스트하기 위해 필요한 의존성 모음
spring-boot-starter-validation	유효성 검사를 위해 필요한 의존성 모음
spring-boot-starter-actuator	모니터링을 위해 애플리케이션에서 제공하는 다양한 정보를 제공하기 쉽게 하는 의존성 모음
spring-boot-starter-data-jpa	ORM을 사용하기 위한 인터페이스의 모음인 JPA를 더 쉽게 사용하기 위한 의존성 모음


build.gradle에 들어가면

현재 내가 사용하고 있는 web 스타터와 test 스타터가 의존성으로 명시되어 있다.

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
}


IDE의 가장 오른쪽에 있는 [Gradle] 탭에 Dependencies 항목을 누르면 스타터를 확인할 수 있고 각 스타터에 어떤 의존성이 있는지도 볼 수 있다. 



자동구성



스프링 부트에서는 애플리케이션이 최소한의 설정만으로도 실행되게 여러 부분을 자동으로 구성한다.



스프링 부트는 서버를 시작할 때 구성 파일을 읽어와서 설정한다.

-> 이를 자동 설정이라고 한다. 



스프링 부트에서는 빈이 자동으로 등록되고 구성된다. 만약 이런 자동 구성이 없었더라면 개발자가 특정 기술을 사용할 때마다 설정해야 하는 값을 모두 개발자가 직접 설정해야 한다. 



2.4 스프링 부트 3 코드 이해하기 
@SpringBootApplication 이해하기
package me.shinsunyoung.springbootdeveloper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDeveloperApplication {
    public static void main(String[] args) {
       SpringApplication.run(SpringBootDeveloperApplication.class, args);
    }
}


이 클래스는 자바의 main()메서드와 같은 역할을 한다.

즉, 여기서 부터 스프링 부트가 시작된다고 생각하면 된다!



@SpringBootApplication 애너테이션을 추가하면 스프링 부트 사용에 필요한 기본 설정을 해준다. 

-> 스프링부트의 핵심 애너테이션이다!

SpringApplication.run()메서드는 애플리케이션을 실행한다.

첫 번째 인수는 스프링 부트 3 애플리케이션의 메인 클래스로 사용할 클래스, 두 번째 인수는 커맨드 라인의 인수들을 전달한다. 



@SpringBootConfiguration 
: 스프링 부트 관련 설정을 나타내는 애너테이션이다. 



@SpringBootConfiguration은 @Configuration을 상속해서 만든 애너테이션이다. 



@ComponentScan
: 사용자가 등록한 빈을 읽고 등록하는 애너테이션이다. 

이 애너테이션은 @Component라는 애너테이션을 가진 클래스들을 찾아 빈으로 등록하는 역할을 한다.

@Component를 감싸는 애너테이션이 있는데 실제 개발을 하면 @Component 애너테이션보다는  용도에 따라 아래 표에 있는 애너테이션을 사용한다. 

애너테이션명	설명
@Configuration	설정 파일 등록
@Repository	ORM 매핑
@Controller, @RestController	라우터
@Service	비즈니스 로직
@EnableAutoConfiguration
: 스프링 부트에서 자동 구성을 활성화하는 애너테이션이다.

이 애너테이션은 부트 서버가 실행될 때 스프링 부트의 메타 파일을 읽고 정의된 설정들을 자동으로 구성하는 역할을 수행한다.



테스트 컨트롤러 살펴보기
@RestController
public class TestController {
 	@GetMapping("/test")
 		public String test()
		 return "Hello, world!";
 		}
 }
 
 /test GET 요청이 오면 test() 메서드가 실행된다.


@RestController는 라우터 역할을 하는 애너테이션이다. 

라우터란 HTTP 요청과 메서드를 연결하는 장치를 말한다. 이 애너테이션이 있어야 클라이언트의 요청에 맞는 메서드를 실행할 수 있다. 



위의 코드 경우는 TestController를 라우터로 지정해 /test라는 GET 요청이 왔을 때 test() 메서드를 실행하도록 구성했다.



@RestController는 @Controller 애너테이션과 @ResponseBody 애너테이션이 합쳐진 결과물이다. 



위에서 소개했던 @Controller, @Configuration, @Repository, @Service 애너테이션 모두 @Component 애너테이션을 가지고 있다. 그렇기 때문에 위의 애너테이션들이 @ComponentScan을 통해 빈으로 등록되는 것이다. 



핵심 요약


1. 스프링은 엔터프라이즈 애플리케이션을 쉽게 개발할 수 있도록 도와주는 프레임워크이다.

2. Ioc는 제어의 역전, DI는 의존성 주입을 말한다.

3. 스프링 부트는 스프링을 더 빠르고 쉽게 사용하기 위한 도구로서 스타터와 자동 구성을 제공한다.

4. 애너테이션은 자바 소스 코드에 추가하는 표식으로 보통 @ 기호를 앞에 붙여 사용한다.

5. @SpringBootApplication은 스프링 부트 관련 설정을 하는 @SpringBootConfiguration, 사용자가 등록한 빈을 읽고 등록하는 @ComponentScan, 자동 설정으로 등록되는 빈을 읽고 등록하는 @EnableAutoConfiguration으로 이루어져있다.

6. @Component 에너테이션이 있는 클래스는 빈으로 등록되며, @Controller, @RestController, @Configuration, @Repository, @Service 모두 @Componente 애너테이션을 가지고 있다.

상황에 맞는 애너테이션을 선택해야 한다.  













