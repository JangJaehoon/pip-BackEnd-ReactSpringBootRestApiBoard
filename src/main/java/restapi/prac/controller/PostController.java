package restapi.prac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restapi.prac.model.Post;
import restapi.prac.service.PostService;

import java.util.Optional;

//  /api/post/id -> 게시글 생성 : (  /id = /api/post/id  )

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;
//     PostService를 주입해 줌.

    // Paging処理
    @GetMapping()
    public ResponseEntity<Page<Post>> listPost(@RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "10") int size)
    {                                           // 1pageに10個
        Pageable pageable = PageRequest.of(page, size);
        Page<Post> posts = postService.getPosts(pageable);

        return ResponseEntity.ok().body(posts);
        // 게시글을 표시해 줌.
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable Long id){
        // 포스팅 표시  응답 로직
        Optional<Post> postOpt = postService.getPost(id);
        return postOpt.map(ResponseEntity::ok).
                orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post){
        // 포스팅 생성 로직  응답 로직

        // getter, setter역할의 Model Post에 service단에서 처리해온 데이터를 넘겨줌.
        Post createdPost = postService.createPost(post);
        return ResponseEntity.ok(createdPost);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post updatedPost){
        // 포스팅 수정 로직  응답 로직
        Optional<Post> updated
                = postService.updatePost(id, updatedPost);
        // 데이터를 처리하는 서비스단에 데이터를 가져오는 모델 Post에서 가져온 데이터를 서비스에 넘겨줌.
        return updated.map(ResponseEntity::ok)
                .orElseGet( () -> ResponseEntity.notFound().build() );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id){
        // 포스팅 삭제 로직  응답 로직
        boolean deleted = postService.deletePost(id);
        if(deleted){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }

    }

}
