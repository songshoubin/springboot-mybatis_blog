package com.gdufe.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.gdufe.intecepter.SecurityIntercepter;
/**
 * 配置拦截器
 * @author song
 *
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		/**
		 * 拦截器按照顺序执行
		 */
		registry.addInterceptor(new SecurityIntercepter()).addPathPatterns("/admin/**")
        .excludePathPatterns("/admin/")
        .excludePathPatterns("/admin/index.html") 
        .excludePathPatterns("/admin/logout.do") 
        .excludePathPatterns("/admin/login.do"); 
		super.addInterceptors(registry);
	}
}
