package com.example.designpatterns.factory

//is a singleton class with a helper method.
object HostingPackageFactory {
    //is responsible for creating all the objects.
    fun getHostingFrom(type: HostingPackageType): HostingPackageInterface {
        return when (type) {
            HostingPackageType.STANDARD -> {
                Packages.StandardHostingPackage()
            }
            HostingPackageType.PREMIUM -> {
                Packages.PremiumHostingPackage()
            }
        }
    }
}