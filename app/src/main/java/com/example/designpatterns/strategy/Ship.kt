package com.example.designpatterns.strategy

class Ship : TransportTypeStrategy {
    override fun travelMode(): String {
        return "Sea"
    }
}