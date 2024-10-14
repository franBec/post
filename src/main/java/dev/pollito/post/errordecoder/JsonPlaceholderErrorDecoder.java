package dev.pollito.post.errordecoder;

import dev.pollito.post.exception.JsonPlaceholderException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.jetbrains.annotations.NotNull;

public class JsonPlaceholderErrorDecoder implements ErrorDecoder {
  @Override
  public Exception decode(String s, @NotNull Response response) {
    return new JsonPlaceholderException(response.status());
  }
}
