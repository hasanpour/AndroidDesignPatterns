package com.example.designpatterns.factory

class Packages {
    // conforms to the interface and implements the required method to list all the services.
    class StandardHostingPackage : HostingPackageInterface {
        override fun getServices(): List<String> {
            return listOf("a", "b")
        }
    }

    // conforms to the interface and implements the required method to list all the services.
    class PremiumHostingPackage : HostingPackageInterface {
        override fun getServices(): List<String> {
            return listOf("c", "d")
        }
    }
}