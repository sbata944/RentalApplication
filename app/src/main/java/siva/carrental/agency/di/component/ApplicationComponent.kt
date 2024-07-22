package siva.carrental.agency.di.component

import android.content.Context
import dagger.Component
import siva.carrental.agency.demo.launcher.CarAgencyApplication
import siva.carrental.agency.data.api.NetworkService
import siva.carrental.agency.data.repository.TopHeadlineRepository
import siva.carrental.agency.di.ApplicationContext
import siva.carrental.agency.di.module.ApplicationModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: CarAgencyApplication)

    @ApplicationContext
    fun getContext(): Context

    fun getNetworkService(): NetworkService

    fun getTopHeadlineRepository(): TopHeadlineRepository

}