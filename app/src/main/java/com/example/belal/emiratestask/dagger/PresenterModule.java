package com.example.belal.emiratestask.dagger;

import android.content.Context;
import com.example.belal.emiratestask.view.profile.Cars.CarsListPresenter;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;



//this class created to put  providers for Presenters
@Module
public class PresenterModule {


    @Provides
    @Singleton
    CarsListPresenter provideCarsListPresenter(Context context) {

        return new CarsListPresenter(context);
    }











}

