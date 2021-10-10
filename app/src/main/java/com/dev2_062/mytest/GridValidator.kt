package com.dev2_062.mytest

import com.dev2_062.mytest.enums.State

/**
 * Validator class in order to apply several check on list of State
 */
class GridValidator : IGridValidator {

    /**
     * Return true if rows are found complete in the given grid, return false otherwise
     */
    override fun checkRows(input: List<State>): Boolean {
        input.windowed(3, 3).forEach {
            if (isComplete(it)) return true
        }
        return false
    }

    /**
     * Return true if columns are found complete in the given grid, return false otherwise
     */
    override fun checkColumns(grid: List<State>): Boolean {
        for (j in 0..2) {
            val column = grid.windowed(3, 3).mapNotNull { row -> row.getOrNull(j) }

            if (isComplete(column)) return true
        }
        return false
    }

    /**
     * Return true if first diagonal is found complete in the given grid, return false otherwise
     */
    override fun checkFirstDiagonal(grid: List<State>): Boolean {
        val diagonal = listOf(0, 4, 8).mapNotNull { grid.getOrNull(it) }
        return isComplete(diagonal)
    }

    /**
     * Return true if second diagonal is found complete in the given grid, return false otherwise
     */
    override fun checkSecondDiagonal(grid: List<State>): Boolean {
        val diagonal = listOf(2, 4, 6).mapNotNull { grid.getOrNull(it) }
        return isComplete(diagonal)
    }

    /**
     * Return true if none is UNDEFINED, return false otherwise
     */
    override fun isFull(grid: List<State>): Boolean {
        TODO("Not yet implemented")
    }

    /**
     * Return true if all state in given list are all circles or all cross, return false otherwise
     */
    private fun isComplete(input: List<State>) =
        input.all { it == State.CIRCLE } || input.all { it == State.CROSS }

}