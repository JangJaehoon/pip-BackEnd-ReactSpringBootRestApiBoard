package restapi.prac.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import restapi.prac.model.Post;
import restapi.prac.repository.PostRepository;

import java.util.Optional;

// 인터페이스 PostRepository를 구현화하여,
// PostController에서 받아온 데이터를 처리해 주는 로직
@Service
public class PostService {

    private final PostRepository postRepository;

    // 초기화를 위한 생성자 매개변수
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Page<Post> getPosts(Pageable pageable){
        return postRepository.findAll(pageable);
    }

    public Optional<Post> getPost(Long id){
        return postRepository.findById(id);
    }

    public Post createPost(Post post){
        // 저장한 데이터가 리턴됨.
        return postRepository.save(post);
    }

    public Optional<Post> updatePost(Long id,Post updatePost){
        return postRepository.findById(id).map(
            post -> {
                post.setTitle(updatePost.getTitle());
                post.setContent(updatePost.getContent());
//                post.setEmpID(updatePost.getEmpID());
//                post.setInfo(updatePost.getInfo());

                return postRepository.save(post);
            });
    }

    public boolean deletePost(Long id){

       return postRepository.findById(id).map(

               // 찾아야할 게시글
            post -> {
                postRepository.delete(post);
                return true;
            }).orElse(false);


    }
}
