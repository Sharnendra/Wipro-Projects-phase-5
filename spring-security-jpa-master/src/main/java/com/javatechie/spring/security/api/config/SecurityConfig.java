package com.javatechie.spring.security.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/*@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}*/

	/*@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/rest/**").authenticated().anyRequest().permitAll().and()
				.authorizeRequests().antMatchers("/secure/**").authenticated().anyRequest().hasAnyRole("ADMIN").and()
				.formLogin()
				.defaultSuccessUrl("/rest/auth/process")
				.failureUrl("/loginPage?error").
				permitAll();
		
		 http.sessionManagement()
	        .sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
	}*/
	

	@Bean
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
	    return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	    
	    
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers("/rest/auth/processor")
	    	.hasAnyRole("USER")
	    	.anyRequest()
	    	.authenticated()
        .antMatchers("/rest/auth/welcome")
        	.hasAnyRole("USER", "ADMIN")
        .antMatchers("/rest/auth/getEmployees")
        	.hasAnyRole("USER", "ADMIN")
        .antMatchers("/rest/auth/addNewEmployee")
        	.hasAnyRole("ADMIN")
        	.anyRequest()
        	.authenticated()
    	.and().formLogin().defaultSuccessUrl("/rest/auth/welcome").permitAll()
    	.and().logout().permitAll();

        http.csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
    	
    	PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        
    	authenticationMgr.inMemoryAuthentication().withUser("javainuse").password(encoder.encode("javainuse"))
            .authorities("ROLE_USER", "ROLE_ADMIN")
            .and()
            .withUser("javainuse2").password(encoder.encode("javainuse2"))
            .authorities("ROLE_USER")
	    	.and()
	        .withUser("javainuse3").password(encoder.encode("javainuse3"))
	        .authorities("ROLE_ADMIN");
    }
}
