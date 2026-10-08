package restapi.prac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restapi.prac.model.Post;

// PostController에서 받아온 데이터를 처리해 주는 로직
@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
}
