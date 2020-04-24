package com.cofco.business.mapper.base;

import org.springframework.stereotype.Component;

/**
 * Created by Tiago Vilas Boas on 16/06/2018.
 * Long to mapper
 */
@Component
public class LongMapper extends IdentityMapper<Long> {

    @Override
    public Long mapFrom(Long l) {
        return l;
    }

    @Override
    public Long mapTo(Long l) {
        return l;
    }
}
