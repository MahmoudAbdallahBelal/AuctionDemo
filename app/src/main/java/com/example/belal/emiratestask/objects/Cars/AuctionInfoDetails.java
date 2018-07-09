package com.example.belal.emiratestask.objects.Cars;

import com.google.gson.annotations.SerializedName;

/**
 * Created by belal on 7/8/18.
 */

public class AuctionInfoDetails {


    @SerializedName("endDateEn")
    private String endDateEn;

    @SerializedName("endDateAr")
    private String endDateAr;

    @SerializedName("bids")
    private String bids ;

    public String getEndDateEn() {
        return endDateEn;
    }

    public void setEndDateEn(String endDateEn) {
        this.endDateEn = endDateEn;
    }

    public String getEndDateAr() {
        return endDateAr;
    }

    public void setEndDateAr(String endDateAr) {
        this.endDateAr = endDateAr;
    }

    @SerializedName("lot")
    private String lot;


    @SerializedName("currentPrice")
    private String currentPrice;


    @SerializedName("currencyEn")
    private String currencyEn;

    @SerializedName("currencyAr")
    private String currencyAr;

    public String getBids() {
        return bids;
    }

    public void setBids(String bids) {
        this.bids = bids;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public String getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(String currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getCurrencyEn() {
        return currencyEn;
    }

    public void setCurrencyEn(String currencyEn) {
        this.currencyEn = currencyEn;
    }

    public String getCurrencyAr() {
        return currencyAr;
    }

    public void setCurrencyAr(String currencyAr) {
        this.currencyAr = currencyAr;
    }
}
