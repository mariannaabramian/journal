package com.marka.journal.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity // аннотация включает Spring Security
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    // конфигурируем какие пути хотим открыть для всех или для отдельных ролей
    // остальные - обрабатываются через контроллеры
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().permitAll();
//                .antMatchers("/css/**", "/js/**", "/webjars/**").permitAll()
//                .antMatchers("/", "/index", "/main", "/guide", "/support", "/about", "/login-page", "/submit-login-form").permitAll()
//                .antMatchers("/", "/index", "/main", "guide", "support", "about", "login-page", "submit-login-form").permitAll()
//                .antMatchers("documents").authenticated()
//                .antMatchers("users").hasRole("ROOT")
//                .anyRequest().denyAll();


//                 .antMatchers("/pages/**", "**/*.jsp").denyAll()
//                .antMatchers("/", "/login-page", "/submit-login-form", "/scripts/**").permitAll()
//                .antMatchers("/user/register").anonymous()
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/user/**").hasRole("USER")
//                .antMatchers("/api/user-stat").permitAll()
//                .antMatchers("/api/**").authenticated()
//                .anyRequest().denyAll();

        //астраиваем спринговую регистрационную форму
        http.formLogin()
                .usernameParameter("usernameField")
                .passwordParameter("passwordField")
                .loginProcessingUrl("/submit-login-form") // -> POST
                .loginPage("/login-page");         // redirect to if not authenticated / not logged in

        http.csrf();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();

    }

    @Bean
    public AuthenticationProvider authenticationProvider(
            PasswordEncoder encoder,
            UserDetailsService userDetailsService) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(encoder);
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }
}
