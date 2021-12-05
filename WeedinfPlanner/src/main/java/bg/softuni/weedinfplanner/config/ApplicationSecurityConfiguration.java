package bg.softuni.weedinfplanner.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration

public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public ApplicationSecurityConfiguration(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(this.userDetailsService)
                .passwordEncoder(this.passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/example")
                .permitAll()
                .antMatchers("/supplier-profile/**","/offers/add","/supplier/messages/**")
                    .hasRole("SUPPLIER")
                .antMatchers("/offers/{id}/update/**","/offers/{id}/delete")
                    .access("@webSecurity.isOwnerOfOffer(authentication,#id)")
                .antMatchers("/wedding-checklist/**","/wedding-budget/**","/wedding-guests","/wedding-guests/add-partner", "/wedding","/user-profile/**","/user/messages/**","/messages/from-user/{recipient}")
                .hasRole("USER")
                .antMatchers("/wedding-budget/expense/{id}/errors","/wedding-budget/expense/{id}")
                    .access("@webSecurity.isOwnerOfExpense(authentication,#id)")
                .antMatchers("/wedding-checklist/task/{id}")
                    .access("@webSecurity.isOwnerOfTask(authentication,#id)")
                .antMatchers("/wedding-guests/{id}/errors","/wedding-guests/{id}")
                    .access("@webSecurity.isOwnerOfGuest(authentication,#id)")
                .antMatchers("/admin/**")
                    .hasRole("ADMIN")
                .antMatchers("/","/login","/register/**","/offers","/offers/{id}")
                    .permitAll()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
                    .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied")
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/")
                .failureForwardUrl("/login-error")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");
    }


}
