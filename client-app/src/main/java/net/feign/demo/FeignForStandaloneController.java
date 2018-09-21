package net.feign.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "directHelloService", url = "http://localhost:8085")
@RequestMapping(path = "/target")
public interface FeignForStandaloneController {

    @RequestMapping(method = RequestMethod.GET, path = "/get/from/directlink/{id}")
    String hello(@PathVariable(name = "id") Integer id, @RequestParam(name = "name") String name);

    @RequestMapping(method = RequestMethod.GET, path = "/badlink")
    String callNonExistedEndpoint();
}
