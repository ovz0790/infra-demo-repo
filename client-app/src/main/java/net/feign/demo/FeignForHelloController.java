package net.feign.demo;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "service-app")
public interface FeignForHelloController extends IHelloController {

}