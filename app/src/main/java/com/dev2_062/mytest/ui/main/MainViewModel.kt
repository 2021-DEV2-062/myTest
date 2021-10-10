package com.dev2_062.mytest.ui.main

import androidx.databinding.ObservableArrayMap
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.dev2_062.mytest.GridValidator
import com.dev2_062.mytest.Referee
import com.dev2_062.mytest.enums.GridResult
import com.dev2_062.mytest.enums.State

class MainViewModel : ViewModel() {

    private var grid: MutableList<State> = MutableList(9) { State.UNDEFINED }

    val imageRes = ObservableArrayMap<Int, Int>()

    private val referee = Referee(GridValidator())

    val currentPlayer = ObservableField(State.CIRCLE)

    val result = ObservableField("");

    init {
        currentPlayer.set(State.CIRCLE)

        grid = MutableList(9) { State.UNDEFINED }

        for (i in 0..8) {
            imageRes[i] = 0
        }
    }

    fun onCellClicked(pos: Int) {

        if (grid[pos] != State.UNDEFINED) return

        currentPlayer.get()?.let {
            grid[pos] = it
            imageRes.setValueAt(pos, it.res)
        } ?: return

        when (referee.check(grid)) {
            GridResult.VICTORY -> {
                result.set("${currentPlayer.get()?.name} WIN !!!")
            }
            GridResult.IN_PROGRESS -> {
                currentPlayer.set(currentPlayer.get()?.next())
            }
            else -> {
                result.set("DRAW !!!")
            }
        }
    }
}