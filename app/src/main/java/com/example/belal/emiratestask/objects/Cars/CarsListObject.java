package com.example.belal.emiratestask.objects.Cars;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class CarsListObject {



    @SerializedName("Cars")
    private List<CarsListDetails> Cars;


    public List<CarsListDetails> getCars() {
        return Cars;
    }

    public void setCars(List<CarsListDetails> cars) {
        Cars = cars;
    }
}