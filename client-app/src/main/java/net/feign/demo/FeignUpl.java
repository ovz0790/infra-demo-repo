package net.feign.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "service-app")
public interface FeignUpl {

    @RequestMapping(value = "/target/uploadtest", method = RequestMethod.POST)
    String handleFileUpload(@RequestParam("file") MultipartFile file);
}
