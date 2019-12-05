package pt.app.foodstuff.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pt.app.foodstuff.R;
import pt.app.foodstuff.RecipesRecyclerviewItem;

public class RecipesRecyclerViewAdapter extends RecyclerView.Adapter<RecipesRecyclerViewAdapter.RecipesRecyclerViewHolder> {

    private ArrayList<RecipesRecyclerviewItem> mList;

    public static class RecipesRecyclerViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView textView;

        public RecipesRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.recipesRecyclerViewItemImage);
            textView = itemView.findViewById(R.id.recipesRecyclerViewItemText);
        }
    }

    public RecipesRecyclerViewAdapter(ArrayList<RecipesRecyclerviewItem> list){
        mList = list;
    }

    @NonNull
    @Override
    public RecipesRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipes_recyclerview_item, parent, false);
        RecipesRecyclerViewHolder recipesRecyclerViewHolder = new RecipesRecyclerViewHolder(view);
        return recipesRecyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecipesRecyclerViewHolder holder, int position) {
        RecipesRecyclerviewItem currentItem = mList.get(position);

        holder.imageView.setImageResource(currentItem.getImage());
        holder.textView.setText(currentItem.getText());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
