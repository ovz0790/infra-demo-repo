package net.feign.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/target")
public class StandaloneController {

    @GetMapping(path = "/get/from/directlink/{id}")
    String hello(@PathVariable(name="id") Integer id, @RequestParam(name = "name") String name) {
        return "Hi, " + name + ". Your query position is " + id + ". It's target service via direct link";
    }

}
