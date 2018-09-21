package net.feign.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/feign")
@RequiredArgsConstructor
public class ClientCallController {

    private final FeignForHelloController feignForHelloController;
    private final FeignForStandaloneController feignForStandaloneController;

    @RequestMapping(method = RequestMethod.GET, path = "/get/from/discovery/{id}")
    public String callHello(@PathVariable(name = "id") Integer id, @RequestParam(name = "name") String name){
        return feignForHelloController.hello(id, name) + " Called via feign.";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/get/from/directlink/{id}")
    public String callStandaloneHello(@PathVariable(name = "id") Integer id, @RequestParam(name = "name") String name){
        return feignForStandaloneController.hello(id, name) + " Called via feign.";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/badlink")
    public String callNonExistedEndpoint() {
        return feignForStandaloneController.callNonExistedEndpoint() + " Called via feign.";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/post/to/discovery", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String callCreate(@RequestBody UpdateDto updateDto) {
        return feignForHelloController.create(updateDto) + " Called via feign.";
    }
}
