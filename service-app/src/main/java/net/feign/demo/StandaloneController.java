package net.feign.demo;

import java.io.File;
import java.util.Optional;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path = "/target")
public class StandaloneController {

    @GetMapping(path = "/get/from/directlink/{id}")
    String hello(@PathVariable(name="id") Integer id, @RequestParam(name = "name") String name) {
        return "Hi, " + name + ". Your query position is " + id + ". It's target service via direct link";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/attach/post", consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String gettingAttachedFiles(@RequestParam("files") final MultipartFile files) {
        Optional.ofNullable(files).orElseThrow(() -> new IllegalArgumentException("Files didn't attached!"));

        final StringBuilder sb = new StringBuilder("Target service got files: ");
       /* Arrays.stream(files).forEach(f -> sb.append(" File with name ")
                                            .append(f.getName())
                                            .append("{")
                                            .append(f.getOriginalFilename())
                                            .append(")").append(" has size ")
                                            .append(f.getSize()).append(". "));*/
        sb.append(" File with name ").append(files.getName())
          .append("{")
          .append(files.getOriginalFilename())
          .append(")").append(" has size ")
          .append(files.getSize()).append(". ");
        return sb.toString();
    }

    @RequestMapping(value = "/uploadtest", method = RequestMethod.POST)
    public String handleFileUpload(@RequestParam("file") File file) {
        Optional.ofNullable(file).orElseThrow(() -> new IllegalArgumentException("Files didn't attached!"));
        final StringBuilder sb = new StringBuilder("Target service got files: ");
        sb.append(" File with name ").append(file.getName());
        return sb.toString();
    }

}
