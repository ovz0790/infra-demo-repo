package net.feign.demo;

import feign.FeignException;
import feign.Response;
import feign.codec.Decoder;
import java.io.IOException;
import java.lang.reflect.Type;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;

@Slf4j
public class CustomFeignDecoder extends ResponseEntityDecoder {

    public CustomFeignDecoder(final Decoder decoder) {
        super(decoder);
    }

    @Override
    public Object decode(final Response response, final Type type) throws IOException, FeignException {
        //Here we could add some response handler and/or transformations after getting answer from feign endpoint
        log.error("LOGGING RESPONSE {}", response.body());
        return super.decode(response, type);
    }
}
