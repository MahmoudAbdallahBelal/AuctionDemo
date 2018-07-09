package com.example.belal.emiratestask.view.profile.Cars;


import com.example.belal.emiratestask.baseClass.BaseView;
import com.example.belal.emiratestask.objects.Cars.CarsListDetails;
import com.example.belal.emiratestask.objects.Cars.CarsListObject;

import java.util.List;

//class created for register function for main view
public interface CarsListView extends BaseView {
    void showLoading();
    void hideLoading();
    void showMessage(String message);


    void showCarsList(List<CarsListDetails> carsListDetails);
    void showRefreshInterval(long interval);


}
