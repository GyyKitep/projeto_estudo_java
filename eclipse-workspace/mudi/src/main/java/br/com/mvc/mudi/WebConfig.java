package br.com.mvc.mudi;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import br.com.mvc.mudi.interceptor.IntercepctadorDeAcessos;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
	
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new IntercepctadorDeAcessos()).addPathPatterns("/**");
	}
	
}
