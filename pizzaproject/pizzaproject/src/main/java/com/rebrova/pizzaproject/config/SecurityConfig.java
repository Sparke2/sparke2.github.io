//package com.rebrova.pizzaproject.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//    @Autowired
//    EmployeeRepo employees;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.
//                authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/").permitAll()
//                        .requestMatchers("/User").hasRole("USER")
//                        .requestMatchers("/Admin").hasRole("ADMIN")
//                                .anyRequest().authenticated()
//                        )
//                        .formLogin((form) -> form
//                                .loginPage("/login")
//                                .permitAll()
//                        )
//                        .logout(LogoutConfigurer::permitAll);
//
//        return http.build();
//    }
//    //    @Scope("prototype")
//    @Bean
//    public UserDetailsService userDetailsService() {
////            UserDetails user1 =
////                User.withDefaultPasswordEncoder()
////                        .username("u")
////                        .password("p")
////                        .roles("IT")
////                        .build();
//
//        List<UserDetails> list=new ArrayList<>();
////        list.add(user1);
//
//        for (Employee employee : employees.findAll()) {
//            System.out.println(employee.getLogin());
//            System.out.println(employee.getPassword());
//            System.out.println(employee.getRole().toString());
//            UserDetails user = User.withDefaultPasswordEncoder()
//                    .username(employee.getLogin())
//                    .password(employee.getPassword())
//                    .roles(employee.getRole().toString())
//                    .build();
//            list.add(user);
//        }
//        return new InMemoryUserDetailsManager(list);
//    }
//
////    @Bean
////    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
////        http
////                .authorizeHttpRequests((authz) -> authz
////                        .anyRequest().authenticated()
////                )
////                .httpBasic(withDefaults());
////        return http.build();
////    }
////
////    @Bean
////     protected UserDetailsService userDetailsService() {
////        return new InMemoryUserDetailsManager(
////                User.builder()
////                        .username("admin")
////                        .password(passwordEncoder().encode("admin"))
////                        .roles("ADMIN")
////                        .build()
////        );
////     }
////
////     @Bean
////    protected PasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder(12);
////     }
//
//}
