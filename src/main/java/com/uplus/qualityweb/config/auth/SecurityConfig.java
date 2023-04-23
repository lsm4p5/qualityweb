package com.uplus.qualityweb.config.auth;

import com.uplus.qualityweb.domain.user.Role;
import jakarta.servlet.DispatcherType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;




@Slf4j
@EnableWebSecurity
@RequiredArgsConstructor
//@Configuration(proxyBeanMethods = false)
@Configuration
//@ConditionalOnDefaultWebSecurity
//@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Bean
  //  @Order(SecurityProperties.BASIC_AUTH_ORDER)
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        log.info("filterChain====={}", http.toString());

        http.csrf().disable().cors().disable()
                .headers().frameOptions().disable()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests(request -> request
                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                        .requestMatchers("/","/css/**", "/images/**","/js/**", "/h2-console/**").permitAll()
                        .anyRequest().authenticated()
                )
//                .formLogin(login -> login
//                        .loginPage("/view/login")
//                        .loginProcessingUrl("/login-process")
//                        .usernameParameter("userid")
//                        .passwordParameter("pw")
//                        .defaultSuccessUrl("/view/dashboard", true)
//                        .permitAll()
//                )
                .formLogin().disable()
                .httpBasic().disable()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(customOAuth2UserService);

//        http
//                .csrf().disable()
//                .headers().frameOptions().disable()
//                .and()
//                .authorizeHttpRequests(auth->auth
//                     .requestMatchers("/css/**", "/images/**","/js/**", "/h2-console/**").permitAll()
//                     .requestMatchers("/api/v1/**").hasRole(Role.USER.name())
//                        .anyRequest().authenticated()
//                )
//                .logout()
//                .logoutSuccessUrl("/")
//                .and()
//                .oauth2Login()
//                .userInfoEndpoint()
//                .userService(customOAuth2UserService);

        return http.build();
    }
}

//@RequiredArgsConstructor
//@EnableWebSecurity
//public class SecurityConfig {
//
//    private final CustomOAuth2UserService customOAuth2UserService;
//
//    private static final String[] AUTH_WHITELIST = {
//            "/",
//            "/css/**",
//            "/js/**",
//            "/images/**",
//            "/h2-console/**"
//    };
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//
//        http
//                .csrf().disable()
//                .headers().frameOptions().disable()
//                .and().
//                authorizeHttpRequests(auth ->auth
//                        .requestMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll()
//                        .requestMatchers("/api/vi/**").hasRole(Role.USER.name())
//                        .anyRequest().authenticated()
//                )
//                .logout()
//                .logoutSuccessUrl("/")
//                .and()
//                .oauth2Login()
//                .userInfoEndpoint()
//                .userService(customOAuth2UserService);
//
////        http
////                .csrf().disable()
////                .headers().frameOptions().disable()
////                .and()
////                .authorizeHttpRequests(
////                        (authorize) -> authorize
////                                .requestMatchers(AUTH_WHITELIST).permitAll()
////                                .requestMatchers("/api/v1/**").hasRole(Role.USER.name())
////                               // .anyRequest().authenticated()
////                         )
////                .logout()
////                .logoutSuccessUrl("/")
////                .and()
////                .oauth2Login()
////                .userInfoEndpoint()
////                .userService(customOAuth2UserService);
//
//        return http.build();
//    }
//
//
//}
