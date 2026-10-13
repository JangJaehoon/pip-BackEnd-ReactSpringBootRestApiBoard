package restapi.prac.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder // lombok builder : 自動でbuilerクラス生成
// build methodでinstance生成
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
    @Column(nullable = true)
    public String username; // id
    @Column(nullable = true)
    public String password; // password
//    private String role; // 権限

}
