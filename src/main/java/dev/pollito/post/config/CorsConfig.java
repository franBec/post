package dev.pollito.post.config;

import dev.pollito.post.config.properties.CorsConfigProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class CorsConfig implements WebMvcConfigurer {
  private final CorsConfigProperties corsConfigProperties;

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry
        .addMapping("/**")
        .allowedOrigins(corsConfigProperties.getAllowedOrigins().toArray(new String[0]))
        .allowedMethods(corsConfigProperties.getAllowedMethods().toArray(new String[0]))
        .allowedHeaders(corsConfigProperties.getAllowedHeaders())
        .allowCredentials(corsConfigProperties.getAllowCredentials());
  }
}
