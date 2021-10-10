package com.dev2_062.mytest

import com.dev2_062.mytest.enums.GridResult
import com.dev2_062.mytest.enums.State

interface IReferee {
    fun check(grid: List<State>): GridResult
}
