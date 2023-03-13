package com.svyatdanilov.rest_employee_service.securityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager uds = new InMemoryUserDetailsManager();
        uds.createUser(User.withUsername("user").password("user").authorities("USER").build());
        uds.createUser(User.withUsername("admin").password("admin").authorities("ADMIN").build());
        return uds;
    }
    //Класс-шифровальщик пароля
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();//никак не шифрует
    }


    //Настройка аутиэнфикейшенманагера через настройку его билдера
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();   // configuring HTTP Basic for authentication
        http.authorizeRequests()
                .antMatchers("/name/**").hasAuthority("USER")
                .antMatchers("/surname/**").hasAuthority("ADMIN");
                //.antMatchers("/**").permitAll();// specifying that any request needs authentication
                //.anyRequest().authenticated();
    }



}
