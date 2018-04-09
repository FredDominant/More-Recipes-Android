package com.example.andeladeveloper.morerecipesandroid.Services;


import com.example.andeladeveloper.morerecipesandroid.Models.Recipes;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoreRecipesClient {

    @GET("recipes")
    Call<Recipes> getAllRecipes();
}
