package com.example.belal.emiratestask.objects.Cars;

import com.google.gson.annotations.SerializedName;

/**
 * Created by belal on 7/9/18.
 */

public class TicksResponse {

    @SerializedName("Ticks")
    private long Ticks;

    public long getTicks() {
        return Ticks;
    }

    public void setTicks(long ticks) {
        Ticks = ticks;
    }
}
