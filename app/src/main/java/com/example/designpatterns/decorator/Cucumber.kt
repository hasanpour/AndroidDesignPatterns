package com.example.designpatterns.decorator

//inherts from SaladDecorator.
class Cucumber(salad: Salad) : SaladDecorator(salad) {
    override fun getIngredient(): String {
        return salad.getIngredient() + ", Cucumber"
    }
}