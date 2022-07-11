package com.jokes.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
@EnableJpaRepositories("com.jokes.back.*")
@ComponentScan(basePackages = { "com.jokes.back.*" })
@EntityScan("com.jokes.back.*")
public class JokesApplication{

	public static void main(String[] args) throws Exception {
		SpringApplication.run(JokesApplication.class, args);
	}

	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
						/*.allowedOrigins("https://gentle-island-01600341e.1.azurestaticapps.net/","https://victorious-forest-05a29d50f.1.azurestaticapps.net","http://localhost:8080","http://localhost:56679","http://localhost:56679/page.Page3.html","https://platform.preview.appgyver.com","https://*.appgyver.com","https://platform.appgyver.com/",
						"https://audaxweb.azurewebsites.net/*","https://audaxweb.azurewebsites.net/page.Page3.html","http://localhost:8080/swagger-ui/index.html")
                        .allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS")//nuevo >>
						//.allowedHeaders(HttpHeaders.AUTHORIZATION, HttpHeaders.CONTENT_TYPE, "accessToken", "CorrelationId", "source")
                    //.exposedHeaders(HttpHeaders.AUTHORIZATION, HttpHeaders.CONTENT_TYPE, "accessToken", "CorrelationId", "source")
                    */.maxAge(4800) ;
            }

        };
    }

}
