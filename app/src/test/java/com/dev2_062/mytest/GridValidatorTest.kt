package com.dev2_062.mytest

import com.dev2_062.mytest.enums.State
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * Test class for GridValidator
 */
class GridValidatorTest {

    private lateinit var gridValidator: IGridValidator

    @Before
    fun setUp() {
        gridValidator = GridValidator()
    }


    // CHECK ROWS TESTS
    @Test
    fun shouldReturnFalseIfNoRowIsComplete() {
        val grid: List<State> = listOf(
            State.CIRCLE, State.UNDEFINED, State.CIRCLE,
            State.UNDEFINED, State.CROSS, State.UNDEFINED,
            State.UNDEFINED, State.CROSS, State.UNDEFINED
        )
        Assert.assertEquals(false, gridValidator.checkRows(grid))
    }

    @Test
    fun shouldReturnTrueIfFirstRowIsCross() {
        val grid: List<State> = listOf(
            State.CROSS, State.CROSS, State.CROSS,
            State.UNDEFINED, State.UNDEFINED, State.UNDEFINED,
            State.UNDEFINED, State.UNDEFINED, State.UNDEFINED
        )
        Assert.assertEquals(true, gridValidator.checkRows(grid))
    }

    @Test
    fun shouldReturnTrueIfSecondRowIsCircles() {
        val grid: List<State> = listOf(
            State.UNDEFINED, State.UNDEFINED, State.UNDEFINED,
            State.CIRCLE, State.CIRCLE, State.CIRCLE,
            State.UNDEFINED, State.UNDEFINED, State.UNDEFINED
        )
        Assert.assertEquals(true, gridValidator.checkRows(grid))
    }

    // CHECK COLUMNS TESTS
    @Test
    fun shouldReturnFalseIfNoColumnIsComplete() {
        val grid: List<State> = listOf(
            State.UNDEFINED, State.UNDEFINED, State.UNDEFINED,
            State.UNDEFINED, State.UNDEFINED, State.UNDEFINED,
            State.UNDEFINED, State.UNDEFINED, State.UNDEFINED
        )
        Assert.assertEquals(false, gridValidator.checkColumns(grid))
    }

    @Test
    fun shouldReturnTrueIfFirstColumnIsCross() {
        val grid: List<State> = listOf(
            State.CROSS, State.UNDEFINED, State.UNDEFINED,
            State.CROSS, State.UNDEFINED, State.UNDEFINED,
            State.CROSS, State.UNDEFINED, State.UNDEFINED
        )
        Assert.assertEquals(true, gridValidator.checkColumns(grid))
    }

    @Test
    fun shouldReturnTrueIfSecondColumnIsCircles() {
        val grid: List<State> = listOf(
            State.UNDEFINED, State.CIRCLE, State.UNDEFINED,
            State.UNDEFINED, State.CIRCLE, State.UNDEFINED,
            State.UNDEFINED, State.CIRCLE, State.UNDEFINED
        )
        Assert.assertEquals(true, gridValidator.checkColumns(grid))
    }


}