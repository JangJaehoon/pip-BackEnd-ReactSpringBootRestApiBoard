package restapi.prac.service;

import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import restapi.prac.model.UserRequestDTO;
import restapi.prac.entity.User;
import restapi.prac.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    private UserRepository userRepository;
//    private PasswordEncoder passwordEncoder;

    public void signUp(UserRequestDTO request) {
        // 既に存在するユーザーの新規加入を防ぐロジック
        if(userRepository.findByUsername( request.getUsername() ).isPresent()) {
            throw new RuntimeException("既に存在するユーザーです。");
        }

        User user = User.builder()
                .username( request.getUsername() )
                .password( request.getPassword() )
                .build();

        userRepository.save(user);
    }
}
