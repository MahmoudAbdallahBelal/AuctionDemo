package com.example.belal.emiratestask.objects.Cars;

import com.google.gson.annotations.SerializedName;

/**
 * Created by belal on 7/8/18.
 */

public class CarsListDetails {



    @SerializedName("makeEn")
    private  String makeEn;

    @SerializedName("makeAr")
    private  String makeAr;

    @SerializedName("image")
    private  String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @SerializedName("AuctionInfo")
    private AuctionInfoDetails AuctionInfo;


    public String getMakeEn() {
        return makeEn;
    }

    public void setMakeEn(String makeEn) {
        this.makeEn = makeEn;
    }

    public String getMakeAr() {
        return makeAr;
    }

    public void setMakeAr(String makeAr) {
        this.makeAr = makeAr;
    }

    public AuctionInfoDetails getAuctionInfo() {
        return AuctionInfo;
    }

    public void setAuctionInfo(AuctionInfoDetails auctionInfo) {
        AuctionInfo = auctionInfo;
    }




}
