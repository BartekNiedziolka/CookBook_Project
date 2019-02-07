package pl.niedziolka.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.niedziolka.model.Component;
import pl.niedziolka.repository.ComponentRepository;

public class ComponentConvereter implements Converter<String, Component> {

    @Autowired
    private ComponentRepository componentRepository;

    @Override
    public Component convert(String s) {
        return componentRepository.findOne(Long.parseLong(s));
    }
}
