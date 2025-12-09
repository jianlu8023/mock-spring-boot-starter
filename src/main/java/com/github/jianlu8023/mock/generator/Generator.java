package com.github.jianlu8023.mock.generator;

import java.lang.reflect.*;

public interface Generator<T> {

    T generate();

    T generate(Class<T> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;
}
