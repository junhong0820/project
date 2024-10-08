package com.spring_boot_mybatis_book.project;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/book_img/**")
				.addResourceLocations("file:///usr/local/project/product_images/product_images/"); // 서버 경로

				//.addResourceLocations("file:///C:/springBootWorkspace/product_images/");
		
		//upload 폴더의 이미지 출력하기 위한 맵핑 설정
		registry.addResourceHandler("/images/**")
		.addResourceLocations("file:///usr/local/project/upload/"); // 서버 경로
	}
}
