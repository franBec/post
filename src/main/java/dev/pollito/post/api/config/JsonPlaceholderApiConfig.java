package dev.pollito.post.api.config;

import com.typicode.jsonplaceholder.api.UserApi;
import dev.pollito.post.config.properties.JsonPlaceholderConfigProperties;
import dev.pollito.post.errordecoder.JsonPlaceholderErrorDecoder;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScans(
    value = {
      @ComponentScan(
          basePackages = {
            "com.typicode.jsonplaceholder.api",
          })
    })
@RequiredArgsConstructor
public class JsonPlaceholderApiConfig {
  private final JsonPlaceholderConfigProperties jsonPlaceholderConfigProperties;

  @Bean
  public UserApi userApi() {
    return Feign.builder()
        .client(new OkHttpClient())
        .encoder(new GsonEncoder())
        .decoder(new GsonDecoder())
        .errorDecoder(new JsonPlaceholderErrorDecoder())
        .logger(new Slf4jLogger(UserApi.class))
        .logLevel(Logger.Level.FULL)
        .target(UserApi.class, jsonPlaceholderConfigProperties.getBaseUrl());
  }
}
