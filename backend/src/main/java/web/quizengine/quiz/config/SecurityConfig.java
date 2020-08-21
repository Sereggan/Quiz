package web.quizengine.quiz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        User.UserBuilder users = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(users.username("user").password("user").roles("USER"))
                .withUser(users.username("admin").password("admin").roles("USER","ADMIN"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/quizzes").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/api/quizzes/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/api/quizzes").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/api/quizzes/solve/**").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/api/quizzes/**").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }
}
