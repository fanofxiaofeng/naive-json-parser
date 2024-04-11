package com.study.model;


public record String(int quotationMark1, Characters characters, int quotationMark2) implements Value {
}
