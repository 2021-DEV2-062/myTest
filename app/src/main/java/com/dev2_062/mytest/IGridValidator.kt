package com.dev2_062.mytest

import com.dev2_062.mytest.enums.State

interface IGridValidator {
    fun checkRows(input: List<State>): Boolean
    fun checkColumns(grid: List<State>): Boolean
    fun checkFirstDiagonal(grid: List<State>): Boolean
    fun checkSecondDiagonal(grid: List<State>): Boolean
}
