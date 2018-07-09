package com.example.belal.emiratestask.view.profile.Cars;

import android.content.Context;

import com.example.belal.emiratestask.R;
import com.example.belal.emiratestask.apiClient.ApiInterface;
import com.example.belal.emiratestask.baseClass.BasePresenter;
import com.example.belal.emiratestask.dagger.DaggerApplication;
import com.example.belal.emiratestask.helper.Utilities;
import com.example.belal.emiratestask.objects.Cars.CarsListObject;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class CarsListPresenter implements BasePresenter<CarsListView> {


    CarsListView mView;
    boolean isLoaded = false;



    //inject api interface object
    @Inject
    ApiInterface mApiInterface;

    @Inject
    Context mContext;


    @Override
    public void onAttach(CarsListView view) {
        mView = view;
        mView.onAttache();

    }



    @Override
    public void onDetach() {
        mView = null;
    }
    //create Constructor to get reference of api interface object
    public CarsListPresenter(Context context){
        ((DaggerApplication)context).getAppComponent().inject(this);
    }

    //this function created to load items from specific endpoint
    public void getCarsList() {



        if(!Utilities.checkConnection(mContext)){
            mView.showMessage("No Internet Connection");
            return;
        }

        mApiInterface.getCarsListObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CarsListObject>() {
                    @Override
                    public final void onCompleted() {

                    }

                    @Override
                    public final void onError(Throwable e) {
                        mView.showMessage("Internet Connection\n"+e.getMessage());
                    }

                    @Override
                    public final void onNext(CarsListObject response) {
                        mView.showCarsList(response.getCars());

                    }
                });





    }





}
