package com.example.designpatterns

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.designpatterns.command.MySpecificEvent
import com.example.designpatterns.composite.Team
import com.example.designpatterns.composite.TheSheeps
import com.example.designpatterns.decorator.Carrot
import com.example.designpatterns.decorator.Cucumber
import com.example.designpatterns.decorator.PlainSalad
import com.example.designpatterns.dependencyInjection.AppComponent
import com.example.designpatterns.dependencyInjection.AppModule
import com.example.designpatterns.dependencyInjection.DaggerAppComponent
import com.example.designpatterns.dependencyInjection.MySharedPreferences
import com.example.designpatterns.factory.HostingPackageFactory
import com.example.designpatterns.factory.HostingPackageType
import com.example.designpatterns.factory.RecyclerAdapter
import com.example.designpatterns.state.Printer
import com.example.designpatterns.strategy.Aeroplane
import com.example.designpatterns.strategy.Ship
import com.example.designpatterns.strategy.TravellingClient
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import javax.inject.Inject

//https://www.raywenderlich.com/18409174-common-design-patterns-and-app-architectures-for-android

class MainActivity : AppCompatActivity() {

    //region Creational Patterns
    private lateinit var component: AppComponent

    @Inject
    lateinit var sharedPreferences: MySharedPreferences
    //endregion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //region Creational Patterns

        // Lookup the recyclerview in activity layout
        val recyclerViewPackages = findViewById<View>(R.id.recyclerViewPackages) as RecyclerView

        // Set layout manager to position the items
        recyclerViewPackages.layoutManager = LinearLayoutManager(this)

        component = DaggerAppComponent.builder().appModule(AppModule(this)).build()

        /****** Dependency Injection *******/
        getMyComponent().inject(this)

        /****** Builder ******/
        findViewById<Button>(R.id.buttonBuilder).setOnClickListener{
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.alert))
                .setMessage(getString(R.string.alert_message_builder))
                .setNegativeButton(getString(R.string.cancel)){
                    dialog, which ->
                    sharedPreferences.putData(getString(R.string.dialog), getString(R.string.cancel))
                    getData()
                }
                .setPositiveButton(getString(R.string.ok)){
                        dialog, which ->
                    sharedPreferences.putData(getString(R.string.dialog), getString(R.string.ok))
                    getData()
                }
                .show()
        }

        getData()

        /****** Singleton ******/
        Singleton.exampleMethod()

        /****** Factory ******/
        val standardPackage = HostingPackageFactory.getHostingFrom(HostingPackageType.STANDARD)
        val adapter = RecyclerAdapter(standardPackage.getServices())
        // Attach the adapter to the recyclerview to populate items
        recyclerViewPackages.adapter = adapter

        //endregion

        //region Structural Patterns

        /****** Decorator ******/
        val cucumberSalad = Cucumber(Carrot(PlainSalad())) // Arugula & Lettuce, Carrot, Cucumber
        findViewById<TextView>(R.id.textViewFullSalad).text = cucumberSalad.getIngredient()
        val carrotSalad = Carrot(PlainSalad())// Arugula & Lettuce, Carrot
        findViewById<TextView>(R.id.textViewCarrotSalad).text = carrotSalad.getIngredient()

        /****** Composite ******/
        val composite = TheSheeps("Armin")
        val koushaTeamComposite = TheSheeps("Kousha")
        val karo = Team("Karo")
        val roxana = Team("Roxana")
        koushaTeamComposite.addTeamMember(karo)
        koushaTeamComposite.addTeamMember(roxana)
        composite.addTeamMember(koushaTeamComposite)
        findViewById<TextView>(R.id.textViewTheSheeps).text = composite.getEntityName() // Armin, Kousha, Karo, Roxana
        //endregion

        //region Behavioral Patterns

        /****** Command ******/
        EventBus.getDefault().post(MySpecificEvent())

        /****** Observer ******/
        Observable.just("one", "two", "three", "four", "five")
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(/* an Observer */)

        /****** Strategy ******/
        val travelClient = TravellingClient(Aeroplane())
        findViewById<TextView>(R.id.textViewStrategy1).text = travelClient.howToTravel() // Travel by Air
        // Change the Strategy to Ship
        travelClient.update(Ship())
        findViewById<TextView>(R.id.textViewStrategy2).text = travelClient.howToTravel() // Travel by Sea

        /****** State ******/
        val printing = Printer()
        printing.startPrinting() // Printed Successfully.
        printing.startPrinting() // Printed Successfully.
        printing.startPrinting() // Printer doesn't have ink.
        printing.installInk() // Ink installed.
        printing.startPrinting() // Printed Successfully.

        //endregion Behavioral Patterns
    }

    //region Creational Patterns
    private fun getData() {
        findViewById<TextView>(R.id.textViewAlertButton).text =
            sharedPreferences.getData(getString(R.string.dialog))
    }

    private fun getMyComponent(): AppComponent {
        return component
    }

    //endregion

    //region Behavior Patterns
    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: MySpecificEvent?) {
        /* Do something */
    }
    //endregion
}