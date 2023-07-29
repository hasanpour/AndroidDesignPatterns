package com.example.designpatterns.strategy

class Car : TransportTypeStrategy {
    override fun travelMode(): String {
        return "Road"
    }
}