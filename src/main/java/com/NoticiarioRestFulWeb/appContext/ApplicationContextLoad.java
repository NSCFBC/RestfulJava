package com.NoticiarioRestFulWeb.appContext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextLoad implements ApplicationContextAware {
//Para uso do Bean
//ApplicationContextLoad.getApplicationContext()
//.getBean(UsuarioRepository.class).findUserByLogin(user);
	@Autowired
	private static ApplicationContext applicationContext;

	@SuppressWarnings("static-access")
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;

	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

}