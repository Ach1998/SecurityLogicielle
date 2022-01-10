package ensa.ma.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling().accessDeniedPage("/resourceNonAutorise.html").and().authorizeRequests().antMatchers("/home.html").permitAll().antMatchers("/compteUser.html").hasRole("User")
     .antMatchers("/admin.html").hasRole("admin").anyRequest().authenticated().and().formLogin()
                ;
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails userDetails = User.builder().username("user1").password(passwordEncoder().encode("user1")).roles("User").build();

        UserDetails userDetails1 = User.builder().username("Admin").password(passwordEncoder().encode("admin")) .roles("admin").build();

        return new InMemoryUserDetailsManager( userDetails,userDetails1 );
    }


}
