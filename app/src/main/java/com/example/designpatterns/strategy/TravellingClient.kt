package com.example.designpatterns.strategy

//composes strategy and uses its functionalities inside the functions exposed to the client side.
class TravellingClient(var strategy: TransportTypeStrategy) {
    fun update(strategy: TransportTypeStrategy) {
        this.strategy = strategy
    }

    fun howToTravel(): String {
        return "Travel by ${strategy.travelMode()}"
    }
}