package com.example.belal.emiratestask.helper;

import android.app.ProgressDialog;
import android.content.Context;

import java.util.Locale;
import java.util.Random;



public class Utilities {

        // TODO Check Internet Connection Status
    public static boolean checkConnection(Context mContext)
    {
            if (ConnectivityReceiver.isConnected()) {
               return  true;
            } else {
                return false;
            }

    }


    // TODO General Progress Dialog until get data from the web server
    public  static void showProgressDialog(ProgressDialog progressDialog, String message, boolean show)
    {
        progressDialog.setMessage(message);
        if(show == true)
            progressDialog.show();
        else
            progressDialog.dismiss();
    }


    public   static  String checkLanguage()
    {

        return Locale.getDefault().getLanguage();
    }



}
