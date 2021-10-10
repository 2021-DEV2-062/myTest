package com.dev2_062.mytest

import com.dev2_062.mytest.enums.State

class GridValidator : IGridValidator {

    override fun checkRows(input: List<State>): Boolean {
        input.windowed(3, 3).forEach {
            if (isComplete(it)) return true
        }
        return false
    }


    private fun isComplete(input: List<State>) =
        input.all { it == State.CIRCLE } || input.all { it == State.CROSS }

}