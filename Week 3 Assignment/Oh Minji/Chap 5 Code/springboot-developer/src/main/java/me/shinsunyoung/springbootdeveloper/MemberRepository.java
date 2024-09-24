package me.shinsunyoung.springbootdeveloper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByName(String name); // 쿼리 메소드: JPA가 정해준 메서드 이름 규칙을 따르면 쿼리문을 특별히 구현하지 않아도 메서드처럼 사용할 수 있음.
}