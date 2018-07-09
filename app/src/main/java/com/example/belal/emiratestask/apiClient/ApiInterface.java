package com.example.belal.emiratestask.apiClient;


import com.example.belal.emiratestask.objects.Cars.CarsListObject;
import com.example.belal.emiratestask.objects.Cars.TicksResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiInterface {

    @GET(EndPoints.GET_CARS)
    Observable<CarsListObject> getCarsListObservable();

    @GET(EndPoints.SET_TICKS)
    Observable<TicksResponse> getTicksObservable(@Query("Ticks") long Ticks);






}
