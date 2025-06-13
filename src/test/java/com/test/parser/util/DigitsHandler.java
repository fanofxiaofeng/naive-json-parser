package com.test.parser.util;

import com.study.model.number.Digits;

import java.util.StringJoiner;

public class DigitsHandler {
    public String buildJoinedResult(Digits digits, java.lang.Object... others) {
        StringJoiner joiner = new StringJoiner("");
        for (Object other : others) {
            joiner.add(other.toString());
        }
        fillJoiner(digits, joiner);
        return joiner.toString();
    }

    public void fillJoiner(Digits digits, StringJoiner joiner) {
        if (digits instanceof Digits.CaseOne caseOne) {
            joiner.add(caseOne.digit().toString());
            return;
        }
        if (digits instanceof Digits.CaseTwo caseTwo) {
            joiner.add(caseTwo.digit().toString());
            fillJoiner(caseTwo.digits(), joiner);
            return;
        }
        throw new IllegalArgumentException();
    }
}
