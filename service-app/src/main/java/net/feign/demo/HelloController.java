package net.feign.demo;

import java.util.Arrays;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
public class HelloController implements IHelloController {

    @Override
    public String hello(@PathVariable(name = "id") Integer id, @RequestParam(name = "name") String name) {
        return "Hi, " + name + ". Your query position is " + id + " It's target service via discovery";
    }


    @Override
    public String create(@RequestBody final UpdateDto updateDto) {
        return updateDto.getName();
    }

}
