package com.luv2code.springboot.cruddemo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig  {



    @Bean
    public UserDetailsManager userDetailsManager (DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "SELECT user_id,pw,active from members where user_id=?");

        //define query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id,role from roles where user_id=?"
        );


        return jdbcUserDetailsManager;
    }



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(configurer->
            configurer
                    .requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
                    .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE")
                    .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("MANAGER")
                    .requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("MANAGER")
                    .requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("ADMIN"));

        // Use HTTP Basic auth
        http.httpBasic(Customizer.withDefaults());

        //csrf off
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }


    /* added support for jdbc. Authorizations  from database, auto-detection
    @Bean
    public UserDetailsManager userDetailsManager (DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

    */


/* // Hard-Coded authorization
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        UserDetails john= User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();
        UserDetails mary= User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("EMPLOYEE,MANAGER")
                .build();
        UserDetails susan= User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE,MANAGER,ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john,mary,susan);
    }
*/
}
