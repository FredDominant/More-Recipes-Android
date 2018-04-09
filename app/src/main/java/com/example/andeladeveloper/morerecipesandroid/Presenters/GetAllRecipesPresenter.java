package com.example.andeladeveloper.morerecipesandroid.Presenters;


import android.util.Log;

import com.example.andeladeveloper.morerecipesandroid.Models.Recipes;
import com.example.andeladeveloper.morerecipesandroid.Services.MoreRecipesService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetAllRecipesPresenter {

    MoreRecipesService moreRecipesService;

    public GetAllRecipesPresenter() {
        if (moreRecipesService == null) {
            moreRecipesService = new MoreRecipesService();
        }
    }

    public void getAllRecipesNetworkCall() {
        moreRecipesService
                .getMoreRecipesData()
                .getAllRecipes()
                .enqueue(new Callback<Recipes>() {
                    @Override
                    public void onResponse(Call<Recipes> call, Response<Recipes> response) {
                        Log.i("", "onResponse: Was called");
                    }

                    @Override
                    public void onFailure(Call<Recipes> call, Throwable t) {
                        Log.i("", "onFailure: was called");
                    }
                });
    }
}
