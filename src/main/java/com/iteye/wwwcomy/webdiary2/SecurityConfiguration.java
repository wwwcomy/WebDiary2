package com.iteye.wwwcomy.webdiary2;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * This is for spring security configuration. If there's no
 * AuthenticationManager bean defined, by default, InMemoryUserDetailsManager
 * will be used, user will be created in UserDetailsServiceAutoConfiguration.
 * 
 * @author wwwcomy
 *
 */
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	/**
	 * This is for excluding swagger related URLs from Spring Security check.
	 */
	private static final String[] AUTH_WHITELIST = {
			// -- Swagger UI v2
			"/v2/api-docs", //
			"/webjars/**", //
			// -- used by both v2 and v3
			"/swagger-resources", //
			"/swagger-resources/**", //
			"/configuration/ui", //
			"/configuration/security", //
			// -- Swagger UI v3 (OpenAPI)
			"/v3/api-docs/**", //
			"/swagger-ui/**"
			// other public endpoints of your API may be appended to this array
	};

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin()
				// .loginPage("/login") // This is for custom login page, although it is the
				// same URL with the out-of-box login page
				.and().authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll()
				//
				.anyRequest().authenticated().and().csrf().disable();
	}

// By default, DelegatingPasswordEncoder will be used by Spring to support
// different kinds of password encoders
//	@Bean
//    public PasswordEncoder passwordEncoder() {
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource);
	}

}
