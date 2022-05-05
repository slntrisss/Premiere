package org.billboard.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//import javax.sql.DataSource;
//
//import static org.billboard.security.ApplicationUserRole.ADMIN;
//import static org.billboard.security.ApplicationUserRole.USER;
//
//@Configuration
//@EnableWebSecurity
//public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private final PasswordEncoder passwordEncoder;
//    private DataSource dataSource;
//    private static final String USER_SQL="SELECT person_id, username, password" +
//            " FROM person WHERE person_id=?";
//    private static final String USER_ROLE="SELECT person_id, role " +
//            "FROM person WHERE person_id=?";
//    @Autowired
//    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder,
//                                     DataSource dataSource) {
//        this.passwordEncoder = passwordEncoder;
//        this.dataSource = dataSource;
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers( "/css/**", "/js/**").permitAll()
//                .antMatchers("/main/**", "/movie/**", "/cinema/**").permitAll()
//                .antMatchers("/admin/**").hasRole(ADMIN.name())
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/admin").permitAll()
//                    .usernameParameter("username")
//                    .passwordParameter("password")
//                    .failureUrl("/admin")
//                    .defaultSuccessUrl("/admin/cinema/list", true)
//                .and()
//                .logout()
//                    .logoutUrl("/logout")
//                    .clearAuthentication(true)
//                    .invalidateHttpSession(true)
//                    .deleteCookies("JSESSIONID")
//                    .logoutSuccessUrl("/admin");
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery(USER_SQL)
//                .authoritiesByUsernameQuery(USER_ROLE);
//    }
//
//    @Override
//    @Bean
//    protected UserDetailsService userDetailsService() {
//        UserDetails admin = User.builder()
//                .username("raim")
//                .password(passwordEncoder.encode("password"))
//                .roles(ADMIN.name())
//                .build();
//        UserDetails user = User.builder()
//                .username("user")
//                .password(passwordEncoder.encode("user"))
//                .roles(USER.name())
//                .build();
//        return new InMemoryUserDetailsManager(admin, user);
//    }
//}
