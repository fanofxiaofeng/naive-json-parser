package com.study.util;

public class OutputHolder {
    private final StringBuilder stringBuilder = new StringBuilder();

    private static final int INDENT_WIDTH_FOR_EACH_LEVEL = 4;

    public void print(String content) {
        stringBuilder.append(content);
    }

    public void println(String content) {
        stringBuilder.append(content).append(System.lineSeparator());
    }

    public void println() {
        stringBuilder.append(System.lineSeparator());
    }

    public void printWithIndentLevel(String content, int indentLevel) {
        stringBuilder.append(" ".repeat(INDENT_WIDTH_FOR_EACH_LEVEL).repeat(indentLevel));
        stringBuilder.append(content);
    }

    public void printlnWithIndentLevel(String content, int indentLevel) {
        printWithIndentLevel(content, indentLevel);
        println();
    }

    public String collect() {
        return stringBuilder.toString();
    }
}
