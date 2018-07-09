package com.example.belal.emiratestask.dagger;


import com.example.belal.emiratestask.view.profile.Cars.CarsListActivity;
import com.example.belal.emiratestask.view.profile.Cars.CarsListPresenter;

import javax.inject.Singleton;

import dagger.Component;


// this class created for register who need inject
@Singleton
@Component(modules = {AppModule.class, NetworkModule.class,PresenterModule.class})
public interface AppComponent {

    void inject(CarsListActivity carsListActivity);
    void inject(CarsListPresenter carsListPresenter);



}
