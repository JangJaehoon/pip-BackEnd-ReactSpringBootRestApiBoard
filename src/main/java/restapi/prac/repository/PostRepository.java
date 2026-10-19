package restapi.prac.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restapi.prac.entity.User;
import restapi.prac.model.Post;

import java.util.Optional;

// PostController에서 받아온 데이터를 처리해 주는 로직
@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    Page<Post> findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(
            String title,
            String content,
            Pageable pageable
    );

    // login ロジック
    Optional<User> findByUsername(String username);
    // login ロジック

    // The Start of 検索ロジック
//    Page<Post> findByTitleContainingOrContentContaining(
//            String title,
//            String content,
//            Pageable pageable
//    );
    // The end of 検索ロジック


}
