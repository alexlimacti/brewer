package com.indeas.brewer.config;

import com.indeas.brewer.security.AppUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ComponentScan(basePackageClasses = AppUserDetailsService.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
				.antMatchers("/layout/**")
				.antMatchers("/images/**");
	}

	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
					.antMatchers("/cidades/nova").hasRole("CADASTRAR_CIDADE")
					.antMatchers("/usuarios/**").hasRole("CADASTRAR_USUARIO")
					.anyRequest().authenticated()
					.and()
				.formLogin()
					.loginPage("/login")
					.permitAll()
					.and()
				.logout()
					.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
					.and()
				.exceptionHandling()
					.accessDeniedPage("/403")
					.and()
				.sessionManagement()
					.invalidSessionUrl("/login")
					.maximumSessions(1)
					.expiredUrl("/login");

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
