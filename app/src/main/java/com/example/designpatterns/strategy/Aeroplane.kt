package com.example.designpatterns.strategy

class Aeroplane : TransportTypeStrategy {
    override fun travelMode(): String {
        return "Air"
    }
}