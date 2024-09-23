###  5장 DB조작이 편해지는 ORM

# 5.1 데이터베이스
---


# 5.2 ORM
---

- 자바의 객체와 db를 연결하는 프로그래밍 기법

- 자바 언어로만 db에 접근해서 원하는 데이터 접근가능하다.

장점:
- SQL을 직접 작성하지않고 사용하는 언어로 db접근가능
- 객체지향적으로 코드작성 가능하여 비즈니스 로직에만 집중가능
- dbms가 추상화되어있어, db종속성이 줄어든다. (어느 db를 쓰나 일관된처리방식)
- erd 의존도 낮추고 유지보수시 유리하다.


단점:
- 복잡성이 커질수록 사용난이도가 올라간다.
- 복잡하고 무거운 쿼리는 ORM으로 해결 불가능한 경우가 있다.


  

## JPA와 하이버네이트
---
- JPA: 자바에서 관계형 db를 사용하는 방식을 정의한 인터페이스. 자바 객체와 db를 연결해 데이터관리. 객체 지향 도메인 모델과 db의 다리역할.
- 하이버네이트:  JPA 인터페이스를 구현한 구현체이자 대표적인 ORM 프레임워크. JDBC API사용. 자바 객체를 통해 db종류 상관없이 db 사용을 자유롭게하는것이 목표.


- 엔티티: db 테이블과 매핑되는(직접연결되는) 객체.
- 엔티티 매니저: 엔티티를 관리해 db와 어플리케이션 사이에서 객체를 생성, 수정, 삭제하는 등의 역할을 한다. 엔티티 매니저는 엔티티 매니저 팩토리가 생성한다.
-  각각의 요청 1개에 엔티티 매니저 팩토리가 엔티티 매니저를 1개씩 생성하여 할당한다.



# 5.4 스프링 데이터와 스프링 데이터 JPA
---

스프링 데이터 JPA -> 


- @Sql("/insert-members.sql") -> 테스트 실행전에 sql문 실행.

- @Query("select ~~") -> SQL 쿼리문을 직접 사용해야하는 경우 Query 어노테이션 사용.
  
- save() -> INSERT문 사용. given



-memberRepository.findAll(): 멤버 엔티티 모두조회

-memberRepository.findById(2L).get(): id(PK)로 엔티티 조회

- PK가 아닌 값으로 조회하는 메서드 사용하기(PK가 아닌 값으로 조회하는 메서드는 기본제공으로 주어지지않는다.)
-> JpaRepository 인터페이스를 상속받는 MemberRepository 인터페이스에 findByName()메서드추가
- public interface MemberRepository extends JpaRepository<Member, Long>

- memberRepsotiry.save(): 멤퍼 엔티티 insert

- memberRepository.saveAll(): 멤버 엔티티 리스트 insert

- memberRepsotiry.deleteById(): id(PK)로 엔티티 삭제
  
- memberRepsotiry.deleteAll(): 모든 데이터삭제. 테스트간 영향을 미치지 않기 위해 전체삭제는 AfterEach에서 주로 쓰인다.

- member.changeName(): Member.java에서 public void changeName(String name){ this.name = name; } 추가.
  -> 업데이트 기능 사용시에는 원래 반드시 @Transactional 트랜잭션을 사용해야함. 하지만 @DataJpaTest에 포함되어있으므로 생략.


# 5.5 예제코드 알기
---

@Entity: 해당 클래스를 db테이블과 매핑. name=""를 쓰면 해당 테이블과 매핑. 안쓰면 클래스명 테이블과 매핑.

@NoArgsConstructor(access = AccessLevel.PROTECTED): 기본생성자.

@Id: 기본키 지정

@GeneratedValue(strategy = GenerationType.IDENTITY): 기본키 자동으로 1씩증가.

@Column: db 컬럼과 매핑.

레포지토리: db CRUD에 사용하는 인터페이스로, 스프링 데이터 JPA에서 제공하는 JpaRepository 클래스 인터페이스를 상속받아 구현. 이떄, 엔티티 Member와 엔티티의 기본키 타입 Long을 인수로 넣어준다. JpaRepository에서 제공하는 기본 메서드 사용가능.
