package com.example.belal.emiratestask.objects.Cars;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class CarsListObject {



    @SerializedName("RefreshInterval")
   private long RefreshInterval;



    @SerializedName("Ticks")
    private long Ticks;

    public long getTicks() {
        return Ticks;
    }

    public void setTicks(long ticks) {
        Ticks = ticks;
    }

    public long getRefreshInterval() {
        return RefreshInterval;
    }

    public void setRefreshInterval(long refreshInterval) {
        RefreshInterval = refreshInterval;
    }

    @SerializedName("Cars")
    private List<CarsListDetails> Cars;


    public List<CarsListDetails> getCars() {
        return Cars;
    }

    public void setCars(List<CarsListDetails> cars) {
        Cars = cars;
    }
}
