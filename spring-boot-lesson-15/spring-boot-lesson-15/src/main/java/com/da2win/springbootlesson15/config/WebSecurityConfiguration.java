package com.da2win.springbootlesson15.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.header.writers.frameoptions.AllowFromStrategy;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // CSRF
        http.csrf().csrfTokenRepository(new CookieCsrfTokenRepository()).requireCsrfProtectionMatcher(
                httpServletRequest -> httpServletRequest.getMethod().equals("POST"));

        // CSP
        http.headers().contentSecurityPolicy("script-src https://code.jquery.com/");

        // X-Frame-Options header, 相同域名是允许
        //http.headers().frameOptions().sameOrigin();

        // X-Frame-Options header, 设置白名单方式
        http.headers().addHeaderWriter(new XFrameOptionsHeaderWriter(new AllowFromStrategy() {
            @Override
            public String getAllowFromValue(HttpServletRequest request) {
                return "helloda2win.com";
            }
        }));

        // XSS header
        http.headers().xssProtection().block(false);

        // 授权
        http.authorizeRequests().anyRequest().fullyAuthenticated()
                .and().formLogin()
                .usernameParameter("name") // 用户名参数
                .passwordParameter("pwd"). // 密码参数
                loginPage("/login").failureForwardUrl("/error").permitAll()
                .and().logout().permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("da2win").password("123456").roles("ADMIN")
                .and().withUser("Percy").password("123456").roles("USER");
    }
}
