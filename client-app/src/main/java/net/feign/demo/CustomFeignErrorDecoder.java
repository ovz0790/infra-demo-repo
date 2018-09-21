package net.feign.demo;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import static feign.FeignException.errorStatus;

@Service
public class CustomFeignErrorDecoder implements ErrorDecoder {
    private static final String HANDL_METHOD_NAME = "FeignForStandaloneController#callNonExistedEndpoint()";

    @Override
    public Exception decode(final String methodKey, final Response response) {
        if (methodKey.equalsIgnoreCase(HANDL_METHOD_NAME) && response.status() == HttpStatus.NOT_FOUND.value()) {
            throw new RuntimeException("This endpoint not exists!");
        }

        return errorStatus(methodKey, response);
    }
}
