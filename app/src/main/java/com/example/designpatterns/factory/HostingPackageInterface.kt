package com.example.designpatterns.factory

//This is a basic interface for all the hosting plans.
interface HostingPackageInterface {
    fun getServices(): List<String>
}