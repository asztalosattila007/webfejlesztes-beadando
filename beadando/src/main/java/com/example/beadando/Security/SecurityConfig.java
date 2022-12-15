package com.example.beadando.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
        authenticationMgr.inMemoryAuthentication()
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .withUser("user").password("password").authorities("ROLE_USER")
                .and()
                .withUser("admin").password("password").authorities("ROLE_USER","ROLE_ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
                .antMatchers("/products").access("hasRole('ROLE_USER')")
                .antMatchers("/customers").access("hasRole('ROLE_USER')")
                .antMatchers("/products/").access("hasRole('ROLE_USER')")
                .antMatchers("/customers/").access("hasRole('ROLE_USER')")
                .antMatchers("/products/new").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/customers/new").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/products/delete").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/customers/delete").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/customers/edit/{id}").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/products/edit/{id}").access("hasRole('ROLE_ADMIN')")
                .and()
                .formLogin()
                .defaultSuccessUrl("/")
                .failureUrl("/login?error")
                .usernameParameter("username").passwordParameter("password")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login");
                //http.cors().disable().csrf().disable();
        ;
    }
}
