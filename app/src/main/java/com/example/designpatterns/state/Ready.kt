package com.example.designpatterns.state

import android.util.Log

//Ready is a concrete class implementing PrinterState to define a ready state of the printer.
class Ready : PrinterState {
    override fun print() {
        Log.i("PRINT_STATE","Printed Successfully.")
    }
}