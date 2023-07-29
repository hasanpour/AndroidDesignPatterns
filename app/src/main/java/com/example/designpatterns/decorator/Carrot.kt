package com.example.designpatterns.decorator

//inherts from SaladDecorator.
class Carrot(salad: Salad) : SaladDecorator(salad) {
    override fun getIngredient(): String {
        return salad.getIngredient() + ", Carrot"
    }
}