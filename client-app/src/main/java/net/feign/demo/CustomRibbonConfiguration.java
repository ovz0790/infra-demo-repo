package net.feign.demo;

import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;
import feign.codec.Decoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.netflix.ribbon.StaticServerList;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@Configuration
public class CustomRibbonConfiguration {

    @Bean
    public ServerList<Server> ribbonServerList() {
        StaticServerList<Server> staticServerList = new StaticServerList<>(new Server("localhost", 8085));
        return staticServerList;
    }

    @Bean
    public Decoder feignDecoder() {
        HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter();
        ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(jacksonConverter);
        return new CustomFeignDecoder(new SpringDecoder(objectFactory));
    }


/*
    @Bean
    public Encoder feignEncoder() {
        HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter();
        ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(jacksonConverter);
        return new CustomFeignEncoder(objectFactory);
    }*/


}
