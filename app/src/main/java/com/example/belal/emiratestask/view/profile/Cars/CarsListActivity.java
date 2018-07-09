package com.example.belal.emiratestask.view.profile.Cars;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.example.belal.emiratestask.R;
import com.example.belal.emiratestask.adapters.CarsRecycleAdapter;
import com.example.belal.emiratestask.dagger.DaggerApplication;
import com.example.belal.emiratestask.objects.Cars.CarsListDetails;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;



public class CarsListActivity extends AppCompatActivity  implements CarsListView , SwipeRefreshLayout.OnRefreshListener{



    CarsRecycleAdapter carsRecycleAdapter ;
    List<CarsListDetails> list = new ArrayList<>();

    @Inject
    CarsListPresenter mCarsListPresenter;

    private LinearLayout linearLayoutBg;

    private RecyclerView mRecycleView;
    private SwipeRefreshLayout mSwipeRefresh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecycleView = (RecyclerView) findViewById(R.id.recycleView);
        mSwipeRefresh = findViewById(R.id.swipe_refresh);
        mSwipeRefresh.setOnRefreshListener(this);

        linearLayoutBg = findViewById(R.id.linearLayout_bg);




        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecycleView.setLayoutManager(mLayoutManager);
        mRecycleView.setItemAnimator(new DefaultItemAnimator());

        ((DaggerApplication) getApplication()).getAppComponent().inject(this);

         mCarsListPresenter.onAttach(this);

         mCarsListPresenter.getCarsList();



    }


    @Override
    public void onAttache() {

    }

    @Override
    public void onDetach() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(String message) {

        Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void showCarsList(List<CarsListDetails> carsListDetails) {



        for (int  i =0 ; i < carsListDetails.size() ; i++)
        {

          list.add(carsListDetails.get(i));



        }

           carsRecycleAdapter = new CarsRecycleAdapter(list , CarsListActivity.this);
           mRecycleView.setAdapter(carsRecycleAdapter);





    }


    @Override
    public void onRefresh() {

        refreshContent();

    }

    private void refreshContent(){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                mCarsListPresenter.getCarsList();
                mSwipeRefresh.setRefreshing(false);
            }
        } , 3000);

        mSwipeRefresh.setColorSchemeColors(Color.RED , Color.GREEN, Color.BLACK);
        AlphaAnimation flashGray = new AlphaAnimation(2F, 0.8F);
        linearLayoutBg.startAnimation(flashGray);


    }


}


