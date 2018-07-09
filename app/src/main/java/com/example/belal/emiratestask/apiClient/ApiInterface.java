package com.example.belal.emiratestask.apiClient;


import com.example.belal.emiratestask.objects.Cars.CarsListObject;

import retrofit2.http.GET;
import rx.Observable;

public interface ApiInterface {

    @GET(EndPoints.GET_CARS)
    Observable<CarsListObject> getCarsListObservable();





}
