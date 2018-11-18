package com.security.SpringBootSecurity.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.security.SpringBootSecurity.repository.UsersRepository;
import com.security.SpringBootSecurity.service.CustomUserDetailsService;

/*@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@EnableJpaRepositories(basePackageClasses = UsersRepository.class)
@EnableWebSecurity*/
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	

	
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		super.configure(auth);
		
		auth.userDetailsService(customUserDetailsService)
		.passwordEncoder(NoOpPasswordEncoder.getInstance());
	}
	 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable();
		http.authorizeRequests()
			.antMatchers("**/secured/**").authenticated()
			.and()
			.formLogin().permitAll();
		    //.formLogin().loginPage("/login.html").permitAll();
	}
	
	//remove this in memory authentication configuration
	// @Autowired
	//public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
	//	authenticationMgr.inMemoryAuthentication().withUser("admin").password("admin").authorities("ROLE_USER").and()
	//			.withUser("javainuse").password("javainuse").authorities("ROLE_USER", "ROLE_ADMIN");
	//} 
	
	
	//Enable jdbc authentication
    //@Autowired
    //public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
    //    auth.jdbcAuthentication().dataSource(dataSource);
    //}
	
	/*private PasswordEncoder getPasswordEncoder() {
     return new PasswordEncoder() {
			
			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public String encode(CharSequence rawPassword) {
				// TODO Auto-generated method stub
				return rawPassword.toString();
			}
		};
	} 
	
*/

	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
	return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
		
}
