package com.cofco.business.mapper.base;

/**
 * Created by Tiago Vilas Boas on 15/06/2018.
 * Interface to map an object to a type to another
 *
 * @param <IN> The input we want to map to another object
 * @param <OUT> The output type of the mapper
 */
public interface Mapper<IN, OUT> {

    /**
     * Maps an object to type IN to OUT
     * @param OUT the input parameter to map of type IN
     * @return The mapped class of the type OUT
     */
    IN mapFrom(OUT OUT);

    /**
     * Maps an object to type IN to OUT
     * @param entity the input parameter to map of type IN
     * @return
     */
    OUT mapTo(IN entity);

    /**
     * Maps an object to type IN to OUT
     * @param out The mapped class of the type OUT
     * @param in the input parameter to map of type IN
     * @return
     */
    OUT map(OUT out, IN in);

}
