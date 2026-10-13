package restapi.prac.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable) // ログインページ非活性化
                .httpBasic(Customizer.withDefaults()) // /private パスで接近可能になる。
                .authorizeHttpRequests(auth->auth
                .requestMatchers("/api/public/**").permitAll() // このURLからの接近は許可する。
                .requestMatchers("/api/private/**").authenticated() // このURLからの接近は認証が必要
                .anyRequest().denyAll() // 他の全てのrequestは防ぐ。
                ); // The end of authorizeHttpRequests
        return http.build();
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

}
