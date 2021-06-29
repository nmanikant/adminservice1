package com.Admini.AdminService.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// Config the credential

	// auto injection of DataSource
	// @Autowired
	// private DataSource dataSource;
	/*
	 * @Override protected void configure(Authentication auth) throws Exception { //
	 * demand specific schema for implementation //
	 * auth.jdbcAuthentication().dataSource(dataSource);
	 * 
	 * UserBuilder builder = User.withDefaultPasswordEncoder(); // create some user
	 * auth.inMemoryAuthentication().withUser(builder.username("admin").password(
	 * "admin").roles("ADMIN"))
	 * .withUser(builder.username("First").password("abc").roles("ADMIN"))
	 * .withUser(builder.username("Second").password("abc").roles("VISITOR"))
	 * .withUser(builder.username("Third").password("abc").roles("ADMIN",
	 * "VISITOR"));
	 * 
	 * }
	 */
	/*
	 * @Override protected void configure(AuthenticationManagerBuilderauth)
	 * throwsException {​​​
	 * auth.inMemoryAuthentication().withUser("ramesh").password(
	 * "{​​​noop}​​​ramesh").roles("USER")
	 * .and().withUser("admin").password("{​​​noop}​​​admin").
	 * credentialsExpired(true).accountExpired(true)
	 * .accountLocked(true).authorities("WRITE_PRIVILEGES",
	 * "READ_PRIVILEGES").roles("ADMIN"); }​​​
	 * 
	 */
	// access rule
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors() // allows the access from another server
				.and().csrf().disable() // avoid conflict with form security
				.authorizeRequests().antMatchers("/login").hasRole("ADMIN").antMatchers("/api/*").hasRole("ADMIN") // patterns/url
																													// to
																													// be
																													// accessed
																													// by
																													// which
																													// roles
				.antMatchers("/home").permitAll() // patterns/url to be accessed by all

				.and().httpBasic(); // type of auth (basic auth token/bearer token)

	}

	// config JWT/OAuth
	/*
	 * @Override public void configure(WebSecurity web) throws Exception { // TODO
	 * Auto-generated method stub super.configure(web); }
	 */
}
