package com.study.model;

public interface Members {
    record CaseOne(Member member) implements Members {

    }

    record CaseTwo(Member member, int comma, Members members) implements Members {

    }

}
