package com.example.andeladeveloper.morerecipesandroid.Models;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Recipe implements Parcelable
{

    @SerializedName("id")
    private Integer id;

    @SerializedName("name")
    private String name;

    @SerializedName("userId")
    private Integer userId;

    @SerializedName("description")
    private String description;

    @SerializedName("ingredients")
    private String ingredients;

    @SerializedName("directions")
    private String directions;

    @SerializedName("views")
    private Integer views;

    @SerializedName("favourites")
    private Integer favourites;

    @SerializedName("upvote")
    private Integer upvote;

    @SerializedName("downvote")
    private Integer downvote;

    @SerializedName("picture")
    private String picture;

    @SerializedName("createdAt")
    private String createdAt;

    @SerializedName("updatedAt")
    private String updatedAt;

    @SerializedName("User")
    private User user;

    public final static Parcelable.Creator<Recipe> CREATOR = new Creator<Recipe>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }

        public Recipe[] newArray(int size) {
            return (new Recipe[size]);
        }

    }
            ;

    protected Recipe(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.userId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.ingredients = ((String) in.readValue((String.class.getClassLoader())));
        this.directions = ((String) in.readValue((String.class.getClassLoader())));
        this.views = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.favourites = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.upvote = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.downvote = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.picture = ((String) in.readValue((String.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.user = ((User) in.readValue((User.class.getClassLoader())));
    }

    public Recipe() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getFavourites() {
        return favourites;
    }

    public void setFavourites(Integer favourites) {
        this.favourites = favourites;
    }

    public Integer getUpvote() {
        return upvote;
    }

    public void setUpvote(Integer upvote) {
        this.upvote = upvote;
    }

    public Integer getDownvote() {
        return downvote;
    }

    public void setDownvote(Integer downvote) {
        this.downvote = downvote;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(userId);
        dest.writeValue(description);
        dest.writeValue(ingredients);
        dest.writeValue(directions);
        dest.writeValue(views);
        dest.writeValue(favourites);
        dest.writeValue(upvote);
        dest.writeValue(downvote);
        dest.writeValue(picture);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(user);
    }

    public int describeContents() {
        return 0;
    }

}
