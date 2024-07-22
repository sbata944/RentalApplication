package siva.carrental.agency.di.component

import dagger.Component
import siva.carrental.agency.di.ActivityScope
import siva.carrental.agency.di.module.ActivityModule
import siva.carrental.agency.ui.topheadline.TopHeadlineActivity

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: TopHeadlineActivity)

}