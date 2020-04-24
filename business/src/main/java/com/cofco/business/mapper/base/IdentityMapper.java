package com.cofco.business.mapper.base;

/**
 *
 * Created by Tiago Vilas Boas on 16/06/2018.
 *
 * Abstract implementation to map objects from the same type
 * It makes a small trick of just returning the input
 * It should make a copy
 * @param <T> Type of the parameter to map
 */
public abstract class IdentityMapper<T> implements Mapper<T,T>{


    public T map(T t) {
        return t;
    }

    public T map(T t, T t2) {
        return t;
    }
}