package com.dev2_062.mytest

import com.dev2_062.mytest.enums.State

interface IGridValidator {
    fun checkRows(input: List<State>): Boolean
}
