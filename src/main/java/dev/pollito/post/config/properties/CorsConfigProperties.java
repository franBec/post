package dev.pollito.post.config.properties;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "cors")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CorsConfigProperties {
  List<String> allowedOrigins;
  List<String> allowedMethods;
  String allowedHeaders;
  Boolean allowCredentials;
}
