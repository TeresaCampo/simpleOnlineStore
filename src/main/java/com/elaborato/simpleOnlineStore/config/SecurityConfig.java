package com.elaborato.simpleOnlineStore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/delete").hasRole("ADMIN")
                                .requestMatchers("/shop/upload").hasRole("ADMIN")
                                .anyRequest().permitAll()
                )
                .formLogin(form -> form
                    .loginPage("/adminLogin")
                    .failureUrl("/adminLogin?error=true")
                    .defaultSuccessUrl("/shop")
                    .permitAll()
                )
               .logout(logout -> logout
                        .logoutUrl("/adminLogin/logout")
                        .logoutSuccessUrl("/shop")
               );
        return http.build();
    }

    @Bean
    UserDetailsManager users(DataSource dataSource) {
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);

        if (!users.userExists("admin")) {
            UserDetails admin = User.builder()
                    .username("admin")
                    .password("$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW")
                    .roles("ADMIN")
                    .build();
            users.createUser(admin);
        }
        return users;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}