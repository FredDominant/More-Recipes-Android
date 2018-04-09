package com.example.andeladeveloper.morerecipesandroid.Services;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoreRecipesService {

    private Retrofit retrofit = null;

    public MoreRecipesClient getMoreRecipesData() {
        final String BASE_URL = "https://fred-recipes.herokuapp.com/api/v1/";

        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(MoreRecipesClient.class);
    }
}
