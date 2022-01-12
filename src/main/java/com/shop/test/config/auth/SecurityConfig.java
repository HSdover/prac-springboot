package com.shop.test.config.auth;

import com.shop.test.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity  //spring Security 설정들을 활성화시켜 준다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable() //h2-console 화면을 사용하기 위해 옵션을 disable
                .and()
                    .authorizeRequests()    //URL별 권한 관리를 설정하는 옵션의 시작점
                    .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()  //권한 관리 대상을 지정하는 옵션 / URL,HTTP 메소드별로 관리가 가능
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                    .anyRequest().authenticated()   //설정된 값 이외의 URL들, authenticated()는 인증된 사용자들만 허용이라는 의미(인증=로그인)
                .and()
                    .logout()
                        .logoutSuccessUrl("/")  //로그아웃 설정에 대한 진입점, 로그아웃 성공 시 / 주소로 이동
                .and()
                    .oauth2Login()  //OAutth2 로그인 기능에 대한 설정의 진입점
                        .userInfoEndpoint() //OAuth2 로그인 성공 이후 사용자 정보를 가져올 때의 설정
                            .userService(customOAuth2UserService);  //소셜 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현체를 등록하고 필요한 기능들을 구현한다.
    }
}
