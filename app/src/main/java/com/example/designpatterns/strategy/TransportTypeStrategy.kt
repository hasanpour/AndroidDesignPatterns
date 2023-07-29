package com.example.designpatterns.strategy

//has a common type for other strategies so it can be interchanged at runtime.
interface TransportTypeStrategy {
    fun travelMode(): String
}