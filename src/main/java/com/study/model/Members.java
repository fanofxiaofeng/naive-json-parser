package com.study.model;

public interface Members {
    record CaseOne(Member member) implements Members {

        @Override
        public int memberCount() {
            return 1;
        }
    }

    record CaseTwo(Member member, int comma, Members members) implements Members {

        @Override
        public int memberCount() {
            return 1 + members.memberCount();
        }
    }

    @ForDebug
    int memberCount();

}
