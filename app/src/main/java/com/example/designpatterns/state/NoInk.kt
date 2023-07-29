package com.example.designpatterns.state

import android.util.Log

//NoInk is a concrete class implementing PrinterState to define that the printer has no ink.
class NoInk : PrinterState {
    override fun print() {
        Log.i("PRINT_STATE","Printer doesn't have ink.")
    }
}