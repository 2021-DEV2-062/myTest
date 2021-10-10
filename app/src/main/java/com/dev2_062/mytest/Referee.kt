package com.dev2_062.mytest

import com.dev2_062.mytest.enums.GridResult
import com.dev2_062.mytest.enums.State

class Referee(private val gridValidator: GridValidator) : IReferee {

    override fun check(grid: List<State>): GridResult {
        with(gridValidator) {
            if (checkRows(grid)
                || checkColumns(grid)
                || checkFirstDiagonal(grid)
                || checkSecondDiagonal(grid)
            ) return GridResult.VICTORY

            if (isFull(grid)) {
                return GridResult.DRAW
            }
        }

        return GridResult.IN_PROGRESS
    }

}
