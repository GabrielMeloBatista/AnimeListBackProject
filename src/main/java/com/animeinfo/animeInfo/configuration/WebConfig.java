/*
 * WebConfig.java
 * Copyright (c) UEG.
 *
 *
 *
 *
 */
package com.animeinfo.animeInfo.configuration;

import com.animeinfo.api.config.ApiWebConfig;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * Classe de configuração referente aos recursos Web MVC da aplicação.
 * 
 * @author UEG
 */
@Configuration
public class WebConfig extends ApiWebConfig {

	/**
	 * Retorna a instância {@link MethodValidationPostProcessor}.
	 *
	 * @return
	 */
	/*@Bean
	public MethodValidationPostProcessor methodValidationPostProcessor() {
		return new MethodValidationPostProcessor();
	}*/

	@Override
	public FilterRegistrationBean corsFilter() {
		FilterRegistrationBean corsFilter = super.corsFilter();
		return corsFilter;
	}
}
