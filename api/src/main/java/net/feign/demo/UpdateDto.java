package net.feign.demo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UpdateDto {
    private Integer id;
    private String name;
}
