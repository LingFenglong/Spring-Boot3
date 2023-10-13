package com.lingfenglong.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class ApplicationSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(requests ->
                        requests.requestMatchers("/").permitAll()
                                .anyRequest().authenticated())

                .formLogin(httpSecurityFormLoginConfigurer ->
                    httpSecurityFormLoginConfigurer.loginPage("/login").permitAll())

                .logout(httpSecurityLogoutConfigurer ->
                    httpSecurityLogoutConfigurer
                            .logoutUrl("/logout").permitAll()
                            .logoutSuccessUrl("/").permitAll()
                );

        return http.build();
    }

    @Bean
        // 帮助security查询用户信息
    UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails zhangsan = User.withUsername("zhangsan")
                .password(passwordEncoder.encode("123"))
                .roles("common")
                .authorities("r", "w")
                .build();

        UserDetails lingfenglong = User.withUsername("lingfenglong")
                .password(passwordEncoder.encode("123"))
                .roles("hr", "common", "admin")
                .authorities("r", "w", "x")
                .build();

        return new InMemoryUserDetailsManager(zhangsan, lingfenglong);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
