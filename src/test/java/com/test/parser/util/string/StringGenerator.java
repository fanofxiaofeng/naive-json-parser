package com.test.parser.util.string;


import com.test.parser.util.Generator;

public class StringGenerator implements Generator {

    private final CharactersGenerator charactersGenerator = new CharactersGenerator();

    @Override
    public java.lang.String generate() {
        return '"' + charactersGenerator.generate() + '"';
    }

    public static void main(String[] args) {
        StringGenerator generator = new StringGenerator();
        for (int i = 0; i < 10; i++) {
            System.out.println(generator.generate());
        }
    }
}
