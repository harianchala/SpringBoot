//package com.excelr.ExcelRMay2026BatchSpringboot.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class MyWebSecurity
//{
//   //Authentication
//	 @Bean
//	    public UserDetailsService userDetailsService() {
//
//	        UserDetails admin1 = User.builder()
//	                .username("hari") //CRUD
//	                .password(passwordEncoder().encode("hari123"))
//	                .authorities("ADMIN")
//	                .build();
//	        
//	        UserDetails admin2 = User.builder()
//	                .username("kailash") //CRUD
//	                .password(passwordEncoder().encode("kailash123"))
//	                .authorities("ADMIN")
//	                .build();
//
//	        UserDetails user1 = User.builder()
//	                .username("ben") //CR
//	                .password(passwordEncoder().encode("ben123"))
//	                .authorities("USER")
//	                .build();
//	        
//	        UserDetails user2 = User.builder()
//	                .username("naruto") //CR
//	                .password(passwordEncoder().encode("naruto123"))  //encoding  Bcrypt
//	                .authorities("USER")
//	                .build();
//
//	        return new InMemoryUserDetailsManager(admin1, admin2,user1,user2);
//	    }
//
//	    @Bean
//	    public PasswordEncoder passwordEncoder() {
//	        return new BCryptPasswordEncoder();
//	    }
//
//	    //Authorisation
//	    @Bean  
//	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//	        
//	        http.authorizeRequests()
//	        .requestMatchers("/show-all-products","/add-new-product-form2").hasAnyAuthority("USER","ADMIN")
//	        .requestMatchers("/deleteProductUI/**","/updateProductFormFE/**").hasAuthority("ADMIN")
//	        .anyRequest().authenticated()
//	        .and()
//	        .formLogin().loginProcessingUrl("/login").successForwardUrl("/show-all-products").permitAll()
//	        .and()
//	        .logout().logoutSuccessUrl("/login").permitAll()
//	        .and()
//	        .exceptionHandling().accessDeniedPage("/403")
//	        .and()
//	        .cors().and().csrf().disable();
//	        return http.build();
//	    }
//
//}