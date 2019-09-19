package it.m_chele.hotels.di;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import it.m_chele.hotels.HotelsListActivity;

@Module
public abstract class ActivityModule {
    @ContributesAndroidInjector()
    abstract HotelsListActivity contributeMainActivity();
}
