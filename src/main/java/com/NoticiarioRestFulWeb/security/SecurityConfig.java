package com.NoticiarioRestFulWeb.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.NoticiarioRestFulWeb.jwt.JWTLoginFilter;
import com.NoticiarioRestFulWeb.jwt.JwtApiAutenticacaoFilter;
import com.NoticiarioRestFulWeb.service.UsuarioService;

/*Mapeaia URL, enderecos, autoriza ou bloqueia acessoa a URL*/
@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UsuarioService implementacaoUserDetailsSercice;
	
	/*Configura as solicitações de acesso por Http*/
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		/*Ativando a proteção contra usuário que não estão validados por TOKEN*/
		http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		
		/*Ativando a permissão para acesso a página incial do sistema EX: sistema.com.br/index*/
		.disable().authorizeRequests().antMatchers("/").permitAll()
		.antMatchers("/index").permitAll()
		.antMatchers("/usuarios/**").permitAll()
		.antMatchers("/noticias/**").permitAll()
		.antMatchers("/categorias/**").permitAll()
//		.antMatchers("/categorias/").hasRole("OPERATOR")
//		.antMatchers("/**").permitAll()
//		.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//		.antMatchers(HttpMethod.GET, "/**").permitAll()
//		.antMatchers(HttpMethod.POST, "/**").permitAll()
//		.antMatchers(HttpMethod.PUT, "/**").permitAll()
		
		/*URL de Logout - Redireciona após o user deslogar do sistema*/
		.anyRequest().authenticated().and().cors().and().logout().logoutSuccessUrl("/index")
		
		/*Maperia URL de Logout e insvalida o usuário*/
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		
		/*Filtra requisições de login para autenticação*/
		.and().addFilterBefore(new JWTLoginFilter("/login", authenticationManager()), 
									UsernamePasswordAuthenticationFilter.class)
		
		/*Filtra demais requisições paa verificar a presenção do TOKEN JWT no HEADER HTTP*/
		.addFilterBefore(new JwtApiAutenticacaoFilter(), UsernamePasswordAuthenticationFilter.class);
	
	}
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

	/*Service que irá consultar o usuário no banco de dados*/	
	auth.userDetailsService(implementacaoUserDetailsSercice)
//	new BCryptPasswordEncoder()
	/*Padrão de codigição de senha*/
//	.passwordEncoder(NoOpPasswordEncoder.getInstance());
	.passwordEncoder(new BCryptPasswordEncoder());
	}

}
