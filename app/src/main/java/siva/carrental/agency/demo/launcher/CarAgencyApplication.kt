package siva.carrental.agency.demo.launcher

import android.app.Application
import siva.carrental.agency.di.component.ApplicationComponent
import siva.carrental.agency.di.component.DaggerApplicationComponent
import siva.carrental.agency.di.module.ApplicationModule

class CarAgencyApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }

}