package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.QuantityComponent;
import pl.coderslab.repository.QuantityComponentRepository;

public class QuantityComponentConverter implements Converter<String, QuantityComponent> {

    @Autowired
    private QuantityComponentRepository quantityComponentRepository;

    @Override
    public QuantityComponent convert(String s) {
        return quantityComponentRepository.findOne(Long.parseLong(s));
    }
}
