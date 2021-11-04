package com.professional.di

import android.content.Context
import com.professional.App
import com.professional.di.modules.ApiModule
import com.professional.di.modules.UTranslatorModule
import com.professional.di.modules.ViewModelModule
import com.professional.rxschedulers.Schedulers
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ApiModule::class,
        UTranslatorModule::class,
        ViewModelModule::class]
)
interface DaggerApplicationComponent : AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun withContext(context: Context)

        @BindsInstance
        fun withSchedulers(schedulers: Schedulers)
        fun build(): DaggerApplicationComponent
    }
}