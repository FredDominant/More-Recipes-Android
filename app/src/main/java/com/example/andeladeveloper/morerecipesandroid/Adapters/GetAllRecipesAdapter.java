package com.example.andeladeveloper.morerecipesandroid.Adapters;

import android.annotation.SuppressLint;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.andeladeveloper.morerecipesandroid.Models.Recipe;
import com.example.andeladeveloper.morerecipesandroid.R;
import com.squareup.picasso.Picasso;


import java.util.List;


public class GetAllRecipesAdapter extends RecyclerView.Adapter<GetAllRecipesAdapter.ViewHolder> {

    private List<Recipe> recipes;

    public GetAllRecipesAdapter(List<Recipe> recipes) {
        this.recipes = recipes;
    }
    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     * <p>
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     * <p>
     * The new ViewHolder will be used to display items of the adapter using
     * {@link #onBindViewHolder(ViewHolder, int, List)}. Since it will be re-used to display
     * different items in the data set, it is a good idea to cache references to sub views of
     * the View to avoid unnecessary {@link View#findViewById(int)} calls.
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     * @see #getItemViewType(int)
     * @see #onBindViewHolder(ViewHolder, int)
     */
    @Override
    public GetAllRecipesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ConstraintLayout view = (ConstraintLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.partial_recipe_card, parent, false);
        return new GetAllRecipesAdapter.ViewHolder(view);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     * <p>
     * Note that unlike {@link ListView}, RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the <code>position</code> parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use {@link ViewHolder#getAdapterPosition()} which will
     * have the updated adapter position.
     * <p>
     * Override {@link #onBindViewHolder(ViewHolder, int, List)} instead if Adapter can
     * handle efficient partial bind.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(GetAllRecipesAdapter.ViewHolder holder, int position) {
        holder.setValues(this.recipes.get(position));
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return this.recipes.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

         ImageView recipeImage;
         TextView recipeName;
         TextView recipeOwner;
         TextView favourites;
         TextView likes;
         TextView unlikes;

        ViewHolder(View itemView) {
            super(itemView);

            recipeImage = itemView.findViewById(R.id.recipe_image);
            recipeName = itemView.findViewById(R.id.recipe_name);
            recipeOwner = itemView.findViewById(R.id.recipe_owner);
            favourites = itemView.findViewById(R.id.recipe_favourite_count);
            likes = itemView.findViewById(R.id.recipe_like_count);
            unlikes = itemView.findViewById(R.id.recipe_unlike_count);
        }

        public void setValues(Recipe recipe) {
            Picasso.with(itemView.getContext())
                    .load(recipe.getPicture())
                    .placeholder(R.drawable.avatar)
                    .error(R.drawable.avatar)
                    .into(recipeImage);

            recipeName.setText(recipe.getName().toString());
            recipeOwner.setText(recipe.getUser().getFirstName()
                    + ' ' + recipe.getUser().getLastName());
            favourites.setText(Integer.toString(recipe.getFavourites()));
            likes.setText(Integer.toString(recipe.getUpvote()));
            unlikes.setText(Integer.toString(recipe.getDownvote()));

        }
    }
}
