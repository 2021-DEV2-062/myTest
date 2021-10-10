package com.dev2_062.mytest.enums

import com.dev2_062.mytest.R

enum class State(val res: Int) {
    CIRCLE(R.drawable.ic_circle), CROSS(R.drawable.ic_cross), UNDEFINED(0);

    override fun toString(): String {
        return res.toString()
    }

    fun next(): State {
        return if (this == CIRCLE) {
            CROSS
        } else {
            CIRCLE
        }
    }
}