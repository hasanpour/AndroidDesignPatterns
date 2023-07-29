package com.example.designpatterns.composite

//A Team class implements an Entity. It’s a Leaf.
class Team(private val name: String) : Entity {
    override fun getEntityName(): String {
        return name
    }
}