package restapi.prac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello") // -> security設定変更によって、接近不可能になった。
    public String hello(){
        return "Hello, World!";
    }

//    @GetMapping("/signup") // -> security設定変更によって、接近不可能になった。
//    public String hello(){
//        return "signup page!";
//    }

//    @GetMapping("/api/public/hello")
//    public String publicHello()
//    {
//        return "Public Hello World";
//    }
//
//    @GetMapping("/api/private/hello")
//    public String privateHello(){
//        return "Private Hello World";
//    }
    // privateで接近する場合、
    // application.propertiesに名前、パスワード保存
    //    spring.security.user.name=jjhgwx
    //    spring.security.user.password=lj0131
}
