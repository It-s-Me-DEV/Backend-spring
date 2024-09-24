package me.shinsunyoung.springbootdeveloper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@DataJpaTest
class MemberRepositoryTest {
  @Autowired
  MemberRepository memberRepository;

  @AfterEach
  public void cleanUp() {
      memberRepository.deleteAll();
  }

  @Sql("/insert-members.sql") // 테스트 실행 전에 SQL 스크립트를 실행함
  @Test
  void getAllMembers() {
      // when
      List<Member> members = memberRepository.findAll();

      // then
      assertThat(members.size()).isEqualTo(3);
  }

  @Sql("/insert-members.sql")
  @Test
  void getMemberById() {
      // when
      Member member = memberRepository.findById(2L).get();

      // then
      assertThat(member.getName()).isEqualTo("B");
  }

    @Sql("/insert-members.sql")
    @Test
    void getMemberByName() {
        // when
        Member member = memberRepository.findByName("C").get(); // JPA는 메서드 이름으로 쿼리를 작성하는 기능을 제공하기 때문에 MemberRepository에 동적 메서드를 정의하여 쿼리를 만들고 테스트에 가져다 쓰기만 하면 됨.

        // then
        assertThat(member.getId()).isEqualTo(3);
    }

    @Test
    void saveMember() {
        // given
        Member member = new Member(1L, "A");

        // when
        memberRepository.save(member); // 레코드 추가

        // then
        assertThat(memberRepository.findById(1L).get().getName()).isEqualTo("A");
    }
    @Test
    void saveMembers() {
        // given
        List<Member> members = List.of(new Member(2L, "B"), new Member(3L, "C"));

        // when
        memberRepository.saveAll(members); // 한꺼번에 여러 레코드 추가

        // Then
        assertThat(memberRepository.findAll().size()).isEqualTo(2);
    }

    @Sql("/inset-members.sql")
    @Test
    void deleteMemberById() {
        // when
        memberRepository.deleteById(2L); // 아이디로 레코드 삭제

        // then
        assertThat(memberRepository.findById(2L).isEmpty()).isTrue();
    }

    @Sql("/inset-members.sql")
    @Test
    void deleteALl() { // 모든 데이터를 삭제하므로 실제로 서비스 코드에는 사용하지 않지만 테스트 격리성 보장을 위하여 사용됨
        // when
        memberRepository.deleteAll(); // 모든 레코드 삭제

        // then
        assertThat(memberRepository.findAll().size()).isZero();
    }

    @Sql("/inser-members.sql")
    @Test
    void update() {
        // given
        Member member = memberRepository.findById(2L).get();

        // when
        member.changeName("BC"); // @DataJpaTest(@Transactional) 애너테이션을 활용해 영속 상태에서 데이터 필드값이 변경되면 자동으로 변경 감지를 하는 JPA의 기능을 적용하여 데이터베이스 변경시킴.
                                    // 여기선 @Transactional을 포함하는 @DataJpaTest으로 데이터베이스에 대한 트랜잭션 관리 설정을 했지만, 서비스 기능에서는 반드시 @Transactional을 붙여야 됨.
        // then
        assertThat(memberRepository.findById(2L).get().getName()).isEqualTo("BC");
    }
}