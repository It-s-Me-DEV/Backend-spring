package ITisme.group.chap06.repository;

import ITisme.group.chap06.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Article, Long> {

}