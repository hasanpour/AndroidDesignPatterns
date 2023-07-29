package com.example.designpatterns.decorator

// helps add more toppings to the PlainSalad.
open class SaladDecorator(protected var salad: Salad) : Salad {
    override fun getIngredient(): String {
        return salad.getIngredient()
    }
}