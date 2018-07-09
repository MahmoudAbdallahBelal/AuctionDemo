package com.example.belal.emiratestask.adapters;

import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.belal.emiratestask.R;
import com.example.belal.emiratestask.apiClient.EndPoints;
import com.example.belal.emiratestask.helper.GlideApp;
import com.example.belal.emiratestask.helper.Utilities;
import com.example.belal.emiratestask.objects.Cars.CarsListDetails;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

/**
 * Created by belal on 7/8/18.
 */

public class CarsRecycleAdapter extends RecyclerView.Adapter<CarsRecycleAdapter.MyViewHolder> {

    String day , month , hour, minute , hourType;

    private List<CarsListDetails> carsList;
    private  Context context;
    private int lastPosition = -1;
    long minutes;
    String endDateArray[];

    long total_millis;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView carUrl;
        public TextView carName , carPrice , carPriceCurrency, lotTxt , bidsTxt,leftTimeText;


        int timerflag  = 0;
        CountDownTimer cdt;


        public MyViewHolder(View view) {
            super(view);
            carUrl = (ImageView) view.findViewById(R.id.imageView4_car);
            carName = view.findViewById(R.id.textView5_make);
            carPrice = view.findViewById(R.id.textView6_price);
            carPriceCurrency = view.findViewById(R.id.textView7_currency);
            lotTxt = view.findViewById(R.id.textView9_lot);
            bidsTxt = view.findViewById(R.id.textView11_bids);
            leftTimeText = view.findViewById(R.id.textView13_time_left);









        }
    }


    public CarsRecycleAdapter(List<CarsListDetails> carsList , Context context) {
        this.carsList = carsList;
        this.context =context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_car, parent, false);



        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {



        if(Utilities.checkLanguage().equals("en")) {
            holder.carName.setText(carsList.get(position).getMakeEn());
            holder.carPrice.setText(carsList.get(position).getAuctionInfo().getCurrentPrice());
            holder.carPriceCurrency.setText(carsList.get(position).getAuctionInfo().getCurrencyEn());

            holder.lotTxt.setText(carsList.get(position).getAuctionInfo().getLot());
            holder.bidsTxt.setText(carsList.get(position).getAuctionInfo().getBids());
        }
        else if(Utilities.checkLanguage().equals("ar")) {
            holder.carName.setText(carsList.get(position).getMakeAr());
            holder.carPrice.setText(carsList.get(position).getAuctionInfo().getCurrentPrice());
            holder.carPriceCurrency.setText(carsList.get(position).getAuctionInfo().getCurrencyAr());

            holder.lotTxt.setText(carsList.get(position).getAuctionInfo().getLot());
            holder.bidsTxt.setText(carsList.get(position).getAuctionInfo().getBids());
        }


        GlideApp.with(context)
                .load(carsList.get(position).getImage().replace(EndPoints.OLD_TARGET_IMAGE_GENERAL_SIZE,EndPoints.REPLACED_IMAGE_SIZE))
                .centerCrop()
                .into(holder.carUrl);




        prepareDate(carsList ,position ,holder);





    }

    @Override
    public int getItemCount() {
        return carsList.size();
    }




    private void prepareDate(List<CarsListDetails> carsListDetails, final int position , final MyViewHolder holder)
    {



        String endDate=carsListDetails.get(position).getAuctionInfo().getEndDateEn();
        endDateArray = endDate.split(" ");

        day = endDateArray[0];
        month = endDateArray[1];

        String hourArrayMinute[] = endDateArray[2].split(":");

        hour = hourArrayMinute[0];
        minute = hourArrayMinute[1];

        hourType = endDateArray[3];

        long endMonth = 0 ,endHour = 0;

        switch (month) {
            case "Jan":
                endMonth = 1;
                break;

            case "Feb":
                endMonth = 2;
                break;

            case "Mar":
                endMonth = 3;
                break;
            case "Apr":
                endMonth = 4;
                break;

            case "May":
                endMonth = 5;
                break;

            case "Jun":
                endMonth = 6;
                break;

            case "Jul":
                endMonth = 7;
                break;

            case "Aug":
                endMonth = 8;
                break;

            case "Sep":
                endMonth = 9;
                break;

            case "Oct":
                endMonth = 10;
                break;

            case "Nov":
                endMonth = 11;
                break;

            case "Dec":
                endMonth = 12;
                break;

        }

        if(hourType .equals("PM"))
        {
            switch (hour)
            {
                case "1" :

                    endHour = 13;
                    break;

                case "2" :

                    endHour = 14;
                    break;
                case "3" :

                    endHour = 15;
                    break;

                case "4" :

                    endHour = 16;
                    break;

                case "5" :

                    endHour = 17;
                    break;

                case "6" :

                    endHour = 18;
                    break;

                case "7" :

                    endHour = 19;
                    break;


                case "8" :

                    endHour = 20;
                    break;

                case "9" :

                    endHour = 21;
                    break;

                case "10" :

                    endHour = 22;
                    break;

                case "11" :

                    endHour = 23;
                    break;

            }

        }
        else if(hourType.equals("AM"))
        {
            switch (hour)
            {
                case "1" :

                    endHour = 1;
                    break;

                case "2" :

                    endHour = 2;
                    break;
                case "3" :

                    endHour = 3;
                    break;

                case "4" :

                    endHour = 4;
                    break;

                case "5" :

                    endHour = 5;
                    break;

                case "6" :

                    endHour = 6;
                    break;

                case "7" :

                    endHour = 7;
                    break;


                case "8" :

                    endHour = 8;
                    break;

                case "9" :

                    endHour = 9;
                    break;

                case "10" :

                    endHour = 10;
                    break;

                case "11" :

                    endHour = 11;
                    break;


                case "12" :

                    endHour = 0;
                    break;
            }


        }


        Calendar start_calendar = Calendar.getInstance();
        Calendar end_calendar = Calendar.getInstance();
        long start_millis = start_calendar.getTimeInMillis(); //get the start time in milliseconds
        end_calendar.set(2018, (int) endMonth-1, Integer.parseInt(day), (int) endHour,   Integer.parseInt(minute));
        long end_millis = end_calendar.getTimeInMillis(); //get the end time in milliseconds


         total_millis = (end_millis - start_millis); //total time in milliseconds


            //1000 = 1 second interval
            holder.cdt = new CountDownTimer(total_millis, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {


                    long days = TimeUnit.MILLISECONDS.toDays(millisUntilFinished);
                    millisUntilFinished -= TimeUnit.DAYS.toMillis(days);

                    long hours = TimeUnit.MILLISECONDS.toHours(millisUntilFinished);
                    millisUntilFinished -= TimeUnit.HOURS.toMillis(hours);

                    minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished);
                    millisUntilFinished -= TimeUnit.MINUTES.toMillis(minutes);

                    long seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished);
                    holder.leftTimeText.setText(days + ":" + hours + ":" + minutes + ":" + seconds); //You can compute the millisUntilFinished on hours/minutes/seconds

                    if (hours == 0 && minutes < 5) {
                        holder.leftTimeText.setTextColor(Color.RED);
                    } else {
                        holder.leftTimeText.setTextColor(Color.BLACK);


                    }

                }

                @Override
                public void onFinish() {

                }
            };

            holder.cdt.start();







    }





}