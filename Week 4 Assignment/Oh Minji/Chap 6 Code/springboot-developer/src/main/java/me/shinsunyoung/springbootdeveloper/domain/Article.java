package me.shinsunyoung.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity // 엔티티로 지정
@Getter // 필드에 대해 별도의 코드 없이 모든 필드에 대한 접근자 메서드를 만들 수 있게 됨
@NoArgsConstructor // 접근제어자가 protected인 기본 생성자를 별도의 코드 없이 생성
public class Article {

    @Id // id 필드를 기본키로 저장
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키를 자동으로 1씩 증가
    @Column(name = "id", updatable = false)
    private Long id;
    
    @Column(name = "title", nullable = false) // 'title'이라는 not null 칼럼과 매핑
    private String title;
    
    @Column(name = "content", nullable = false)
    private String content;
    
    @Builder // 빌더 패턴으로 객체 생성: 객체 생성 코드의 가독성을 높여줌, 롬복에서 지원해서 간편하게 객체 생성할 수 있음
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
