package com.github.jianlu8023.mock.generator;

import lombok.extern.slf4j.*;

import java.lang.reflect.*;

@Slf4j
public abstract class AbstractGenerator<T> implements Generator<T> {

    @Override
    public T generate() {
        try {
            ParameterizedType superclass = (ParameterizedType) getClass().getGenericSuperclass();
            Class<T> type = (Class<T>) superclass.getActualTypeArguments()[0];
            return type.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            log.error("Failed to generate instance", e);
        }
        return null;
    }

    @Override
    public T generate(Class<T> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return clazz.getDeclaredConstructor().newInstance();
    }
}