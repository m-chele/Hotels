package it.m_chele.hotels.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import it.m_chele.hotels.HotelsModelImpl;
import it.m_chele.hotels.HotelsPresenterImpl;

@Module
public class PresenterModule {

    @Provides
    @Singleton
    HotelsPresenterImpl provideHotelsPresenter() {
        return new HotelsPresenterImpl(new HotelsModelImpl());
    }
}
