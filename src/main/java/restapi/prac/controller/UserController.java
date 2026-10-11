package restapi.prac.controller;

import org.springframework.web.bind.annotation.*;
import restapi.prac.model.UserRequestDTO;
import restapi.prac.service.UserService;

@RestController
//@RequestMapping("/signup") // http://localhost:8080/signup
//@RequiredArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/signup")
//    @PostMapping("/signup")
    public String signup(@RequestBody UserRequestDTO userRequestDTO) {
        userService.signUp(userRequestDTO);
        return "会員加入成功";
    }
}
