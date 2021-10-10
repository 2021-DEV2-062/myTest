package com.dev2_062.mytest

import com.dev2_062.mytest.enums.GridResult.*
import com.dev2_062.mytest.enums.State
import com.dev2_062.mytest.enums.State.*
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class RefereeTest {

    private lateinit var referee: IReferee

    @Before
    fun setUp() {
        val gridValidator = GridValidator()
        referee = Referee(gridValidator)
    }

    @Test
    fun shouldReturnVictoryIfFirstRowIsAllCircles() {
        val grid: List<State> = listOf(
            CIRCLE, CIRCLE, CIRCLE,
            UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED
        )
        assertEquals(VICTORY, referee.check(grid))
    }

    @Test
    fun shouldReturnVictoryIfFirstColumnIsAllCircles() {
        val grid: List<State> = listOf(
            CIRCLE, UNDEFINED, UNDEFINED,
            CIRCLE, UNDEFINED, UNDEFINED,
            CIRCLE, UNDEFINED, UNDEFINED
        )
        assertEquals(VICTORY, referee.check(grid))
    }

    @Test
    fun shouldReturnVictoryIfFistDiagonalIsAllCircles() {
        val grid: List<State> = listOf(
            CIRCLE, UNDEFINED, UNDEFINED,
            UNDEFINED, CIRCLE, UNDEFINED,
            UNDEFINED, UNDEFINED, CIRCLE
        )
        assertEquals(VICTORY, referee.check(grid))
    }

    @Test
    fun shouldReturnVictoryIfSecondDiagonalIsAllCircles() {
        val grid: List<State> = listOf(
            UNDEFINED, UNDEFINED, CIRCLE,
            UNDEFINED, CIRCLE, UNDEFINED,
            CIRCLE, UNDEFINED, UNDEFINED
        )
        assertEquals(VICTORY, referee.check(grid))
    }

    @Test
    fun shouldReturnInProgressIfContainsOnlyUndefined() {
        val grid: List<State> = listOf(
            UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED
        )
        assertEquals(IN_PROGRESS, referee.check(grid))
    }

    @Test
    fun shouldReturnDrawFirstScene() {
        val grid: List<State> = listOf(
            CROSS, CIRCLE, CROSS,
            CROSS, CROSS, CIRCLE,
            CIRCLE, CROSS, CIRCLE
        )
        assertEquals(DRAW, referee.check(grid))
    }

    @Test
    fun shouldReturnDrawSecondScene() {
        val grid: List<State> = listOf(
            CIRCLE, CROSS, CIRCLE,
            CIRCLE, CROSS, CROSS,
            CROSS, CIRCLE, CIRCLE
        )
        assertEquals(DRAW, referee.check(grid))
    }
}