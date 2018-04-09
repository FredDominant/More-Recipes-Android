package com.example.andeladeveloper.morerecipesandroid.Presenters;


import android.util.Log;

import com.example.andeladeveloper.morerecipesandroid.Models.Recipe;
import com.example.andeladeveloper.morerecipesandroid.Models.Recipes;
import com.example.andeladeveloper.morerecipesandroid.Services.MoreRecipesService;
import com.example.andeladeveloper.morerecipesandroid.Views.Activities.MainActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetAllRecipesPresenter {

    MoreRecipesService moreRecipesService;
    private IGetAllRecipesPresenterInterface getAllRecipesPresenterInterface;

    public GetAllRecipesPresenter(MainActivity view) {
        this.getAllRecipesPresenterInterface = view;
        if (moreRecipesService == null) {
            moreRecipesService = new MoreRecipesService();
        }
    }

    public interface IGetAllRecipesPresenterInterface {
        void onGetAllRecipesFailure(boolean status);
        void onGetAllRecipesSuccess(List<Recipe> recipes);
    }

    public void getAllRecipesNetworkCall() {
        moreRecipesService
                .getMoreRecipesData()
                .getAllRecipes()
                .enqueue(new Callback<Recipes>() {
                    @Override
                    public void onResponse(Call<Recipes> call, Response<Recipes> response) {

                        if (response != null) {
                            if (response.body() != null) {
                                Recipes recipesResponse = response.body();
                                List<Recipe> allRecipes = recipesResponse.getRecipes();
                                getAllRecipesPresenterInterface.onGetAllRecipesSuccess(allRecipes);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<Recipes> call, Throwable t) {
                        getAllRecipesPresenterInterface.onGetAllRecipesFailure(true);
                    }
                });
    }
}
