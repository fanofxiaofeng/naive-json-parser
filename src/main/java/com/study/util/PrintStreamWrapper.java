package com.study.util;

import java.io.PrintStream;

public class PrintStreamWrapper {
    private final PrintStream printStream = System.out;

    public void print(String content) {
        printStream.print(content);
    }

    public void println(String content) {
        printStream.println(content);
    }

    public void printlnWithIndentLevel(String content, int indentLevel) {
        for (int i = 0; i < indentLevel; i++) {
            for (int j = 0; j < 4; j++) {
                printStream.print(' ');
            }
        }
        printStream.println(content);
    }

}
