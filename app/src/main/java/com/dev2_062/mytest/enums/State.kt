package com.dev2_062.mytest.enums

enum class State {
    CIRCLE, CROSS, UNDEFINED;

    fun next(): State {
        return if (this == CIRCLE) {
            CROSS
        } else {
            CIRCLE
        }
    }
}