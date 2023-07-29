package com.example.designpatterns.state

import android.util.Log

//Printer handler does all the printing.
class Printer() {
    private val noInk = NoInk()
    private val ready = Ready()
    private var state: PrinterState
    private var ink = 2

    init {
        state = ready
    }

    private fun setPrinterState(state: PrinterState) {
        this.state = state
    }

    //starts printing.
    fun startPrinting() {
        ink--
        if (ink >= 0) {
            setPrinterState(ready)
        } else {
            setPrinterState(noInk)
        }
        state.print()
    }

    //installs ink.
    fun installInk() {
        ink = 2
        Log.i("PRINT_STATE","Ink installed.")
    }
}