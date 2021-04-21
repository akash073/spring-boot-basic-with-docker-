package com.company.converter;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;

/*
* https://www.codota.com/code/java/classes/org.modelmapper.ModelMapper
* */
public class GenericConverter {


    /**
     * Converts a source to a type destination.
     *
     * @param source                The source object
     * @param destination            The destination object
     * @return                        The object created
     */
    public static <T, E> E mapper(T source, E destination) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.map(source, destination);
        return destination;
    }

    /**
     * Converts a source to a type destination.
     *
     * @param source                The souce object
     * @param destination            The destination object
     * @param mapping                The properties for the mapping process
     * @return                        The object created
     */
    public static <T, E> E mapperWithMapping(T source, E destination, PropertyMap<T, E> mapping) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.addMappings(mapping);
        modelMapper.map(source, destination);

        return destination;
    }
}
