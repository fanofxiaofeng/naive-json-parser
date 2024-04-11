package com.study.model;

public record Number(com.study.model.Integer integer, Fraction fraction, Exponent exponent) implements Value {
}
