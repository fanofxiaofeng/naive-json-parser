package com.test.parser.util;

import java.util.Random;

public abstract class AbstractRandomGenerator<T> implements RandomGenerator<T> {
    protected Random random = new Random();

    protected String doGenerate(Class<T> parentType) {
        Class<?>[] permittedSubclasses = parentType.getPermittedSubclasses();
        int randomIndex = random.nextInt(permittedSubclasses.length);
        @SuppressWarnings("unchecked")
        Class<? extends T> childType = (Class<? extends T>) permittedSubclasses[randomIndex];
        return generate(childType);
    }
}
