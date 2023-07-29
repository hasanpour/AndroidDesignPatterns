package com.example.designpatterns.decorator

//Every salad needs a base. This base is Arugula & Lettuce thus, PlainSalad.
class PlainSalad : Salad {
    override fun getIngredient(): String {
        return "Arugula & Lettuce"
    }
}