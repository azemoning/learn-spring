package dev.azemoning.HelloSpring.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperUtil {
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
