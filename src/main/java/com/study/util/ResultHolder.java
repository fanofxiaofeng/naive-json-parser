package com.study.util;

public class ResultHolder {
    private final StringBuilder stringBuilder = new StringBuilder();

    private final int indentWidthForEachLevel;

    public ResultHolder(int indentWidthForEachLevel) {
        this.indentWidthForEachLevel = indentWidthForEachLevel;
    }

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
        stringBuilder.append(" ".repeat(indentWidthForEachLevel).repeat(indentLevel));
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
