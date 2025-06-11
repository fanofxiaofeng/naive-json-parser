package com.study.model;

public sealed interface Value
        permits
        Object,
        Array,
        String,
        Number,
        Value.CaseTrue,
        Value.CaseFalse,
        Value.CaseNull {

    final class CaseTrue implements Value {
        private static final CaseTrue instance = new CaseTrue();

        private CaseTrue() {

        }

        public static CaseTrue getInstance() {
            return instance;
        }

        @Override
        public java.lang.String toString() {
            return TRUE;
        }
    }

    final class CaseFalse implements Value {
        private static final CaseFalse instance = new CaseFalse();

        private CaseFalse() {
        }

        public static CaseFalse getInstance() {
            return instance;
        }

        @Override
        public java.lang.String toString() {
            return FALSE;
        }
    }

    final class CaseNull implements Value {
        private static final CaseNull instance = new CaseNull();

        private CaseNull() {

        }

        public static CaseNull getInstance() {
            return instance;
        }

        @Override
        public java.lang.String toString() {
            return NULL;
        }
    }

    java.lang.String TRUE = "true";
    java.lang.String FALSE = "false";
    java.lang.String NULL = "null";
}
