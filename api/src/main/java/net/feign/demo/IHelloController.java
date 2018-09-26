package net.feign.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface IHelloController {

    @RequestMapping(method = RequestMethod.GET, path = "/target/get/{id}")
    String hello(@PathVariable(name = "id") Integer id, @RequestParam(name = "name") String name);


    @RequestMapping(method = RequestMethod.POST, value = "/target/post", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    String create(@RequestBody UpdateDto updateDto);
}
