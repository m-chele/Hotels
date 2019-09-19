package it.m_chele.hotels.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import it.m_chele.hotels.HotelsApplication;

@Component(modules = {
        ActivityModule.class,
        PresenterModule.class,
        AndroidInjectionModule.class
})

@Singleton
public interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(HotelsApplication appController);
}
