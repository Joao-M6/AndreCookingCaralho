package pt.app.foodstuff.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pt.app.foodstuff.Adapters.RecipesRecyclerViewAdapter;
import pt.app.foodstuff.R;
import pt.app.foodstuff.RecipesRecyclerviewItem;

public class RecipeFragment extends Fragment {

    private RecyclerView recyclerViewRecipes;
    private RecyclerView.Adapter adapterRecyclerViewRecipes;
    private RecyclerView.LayoutManager layoutManagerRecyclerViewRecipes;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipes, container, false);

        ArrayList<RecipesRecyclerviewItem> itemsList = new ArrayList<>();
        itemsList.add(new RecipesRecyclerviewItem(R.drawable.temp_ic_android, "1"));
        itemsList.add(new RecipesRecyclerviewItem(R.drawable.temp_ic_local_car_wash, "2"));
        itemsList.add(new RecipesRecyclerviewItem(R.drawable.temp_ic_motorcycle, "3"));
        itemsList.add(new RecipesRecyclerviewItem(R.drawable.temp_ic_subway, "4"));

        recyclerViewRecipes = view.findViewById(R.id.recipes_recycler_view);
        recyclerViewRecipes.setHasFixedSize(true);
        layoutManagerRecyclerViewRecipes = new LinearLayoutManager(this.getContext());
        adapterRecyclerViewRecipes = new RecipesRecyclerViewAdapter(itemsList);

        recyclerViewRecipes.setLayoutManager(layoutManagerRecyclerViewRecipes);
        recyclerViewRecipes.setAdapter(adapterRecyclerViewRecipes);

        // RecyclerView with two collumns
        recyclerViewRecipes.setLayoutManager(new GridLayoutManager(this.getContext(), 2));


        return view;
    }
}
