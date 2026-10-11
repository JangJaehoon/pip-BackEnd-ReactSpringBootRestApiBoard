package restapi.prac.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true)
    private String title;
    @Column(nullable = true)
    private String content;

    // ログイン機能
    @Column(nullable = true)
    private String username;
    @Column(nullable = true)
    private String password;
    // ログイン機能

//    @Column(nullable = false)
//    private String empID;
//
//    @Column(nullable = false)
//    private String info;

    public Post() {}
    public Post(String title, String content, String username, String password) {
        this.title = title;
        this.content = content;

        this.username = username;
        this.password = password;
    }



//    public Post(String title, String content, String empID, String info) {
//        this.title = title;
//        this.content = content;
//        this.empID = empID;
//        this.info = info;
//    }

}
