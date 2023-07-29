package com.example.designpatterns.composite

//also implements an Entity interface. It’s a Composite.
class TheSheeps(private val name: String) : Entity {
    private val teamList = arrayListOf<Entity>()

    override fun getEntityName(): String {
        return name + ", " + teamList.map { it.getEntityName() }.joinToString(", ")
    }

    fun addTeamMember(member: Entity) {
        teamList.add(member)
    }
}