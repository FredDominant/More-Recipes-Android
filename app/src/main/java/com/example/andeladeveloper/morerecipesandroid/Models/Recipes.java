package com.example.andeladeveloper.morerecipesandroid.Models;


import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class Recipes implements Parcelable
{

    @SerializedName("numberOfItems")
    private Integer numberOfItems;

    @SerializedName("limit")
    private Integer limit;

    @SerializedName("pages")
    private Integer pages;

    @SerializedName("currentPage")
    private Integer currentPage;

    @SerializedName("recipes")
    private List<Recipe> recipes = null;
    public final static Parcelable.Creator<Recipes> CREATOR = new Creator<Recipes>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Recipes createFromParcel(Parcel in) {
            return new Recipes(in);
        }

        public Recipes[] newArray(int size) {
            return (new Recipes[size]);
        }

    };

    protected Recipes(Parcel in) {
        this.numberOfItems = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.limit = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.pages = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.currentPage = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.recipes, (Recipe.class.getClassLoader()));
    }

    public Recipes() {
    }

    public Integer getNumberOfItems() {
        return numberOfItems;
    }

    public Integer getPages() {
        return pages;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(numberOfItems);
        dest.writeValue(limit);
        dest.writeValue(pages);
        dest.writeValue(currentPage);
        dest.writeList(recipes);
    }

    public int describeContents() {
        return 0;
    }

}