package net.feign.demo;

import feign.RequestTemplate;
import feign.codec.EncodeException;
import java.lang.reflect.Type;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomFeignEncoder extends SpringEncoder {

    public CustomFeignEncoder(final ObjectFactory<HttpMessageConverters> messageConverters) {
        super(messageConverters);
    }

    @Override
    public void encode(final Object object, final Type bodyType, final RequestTemplate template) throws EncodeException {
        if (object instanceof UpdateDto) {
            UpdateDto dto = (UpdateDto) object;
            log.error("LOGGING REQUEST TYPE for name {}", dto.getName());
        }

        //Here we could add some response handler and/or transformations before sending request to feign target endpoint
        // template.body(object.toString().getBytes(), Charsets.UTF_8);
        super.encode(object, bodyType, template);

    }

}