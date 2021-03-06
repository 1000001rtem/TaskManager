package ru.eremin.tm.config;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ru.eremin.tm.filter.JwtTokenFilter;
import ru.eremin.tm.model.entity.enumerated.Role;
import ru.eremin.tm.security.JwtTokenProvider;


/**
 * @autor av.eremin on 29.05.2019.
 */

@EnableWebSecurity
public class WebSecurityConfig {

    @Configuration
    @Order(1)
    public static class ApiSecurityConfig extends WebSecurityConfigurerAdapter {

        @NotNull
        @Autowired
        private UserDetailsService service;

        @NotNull
        @Autowired
        private JwtTokenProvider jwtTokenProvider;

        @Bean
        public BCryptPasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        @Bean
        @Override
        public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
        }

        @Override
        protected void configure(final HttpSecurity http) throws Exception {
            http
                    .addFilterBefore(new JwtTokenFilter(jwtTokenProvider, service), UsernamePasswordAuthenticationFilter.class)
                    .antMatcher("/services/endpoint/**")
                    .csrf().disable();
        }

        @Override
        public void configure(final WebSecurity web) throws Exception {
            web.ignoring().antMatchers(HttpMethod.GET, "/services/**");
            web.ignoring().antMatchers("/services/endpoint/authEndpoint/**");
        }

    }

    @Configuration
    @Order(2)
    public static class SoapSecurityConfig extends WebSecurityConfigurerAdapter {

        @NotNull
        @Autowired
        private UserDetailsService service;

        @NotNull
        @Autowired
        private JwtTokenProvider jwtTokenProvider;

        @Autowired
        private AuthenticationManager authenticationManagerBean;

        @Override
        protected void configure(final HttpSecurity http) throws Exception {
            http
                    .addFilterBefore(new JwtTokenFilter(jwtTokenProvider, service), UsernamePasswordAuthenticationFilter.class)
                    .antMatcher("/api/**")
                    .authorizeRequests()
                    .antMatchers("/api/user/*").hasRole(Role.ADMIN.name())
                    .and()
                    .csrf().disable();
        }

        @Override
        public void configure(final WebSecurity web) throws Exception {
            web.ignoring().antMatchers("/api/auth/**");
            web.ignoring().antMatchers("/api/registration/**");
        }

    }

}
