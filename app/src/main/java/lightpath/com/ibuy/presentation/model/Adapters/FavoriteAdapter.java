package lightpath.com.ibuy.presentation.model.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import lightpath.com.ibuy.R;
import lightpath.com.ibuy.data.entity.Favorite;
import lightpath.com.ibuy.presentation.model.Entities.ItemFavoriteHolder;

/**
 * Created by LUIS on 11/02/2017.
 */

public class FavoriteAdapter extends RecyclerView.Adapter<ItemFavoriteHolder> implements View.OnClickListener{

    ArrayList<Favorite> favoritesArray;
    private View.OnClickListener listenerOnClik;

    public FavoriteAdapter(ArrayList<Favorite> postsArray){
        this.favoritesArray= postsArray;
    }

    public ItemFavoriteHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_favorites, parent, false);
        v.setOnClickListener(this);
        ItemFavoriteHolder pvh = new ItemFavoriteHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ItemFavoriteHolder holder, int position) {
        holder.lblName.setText(favoritesArray.get(position).getName());
        holder.lblCost.setText(favoritesArray.get(position).getCost());
    }

    @Override
    public int getItemCount() {
        return favoritesArray.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listenerOnClik=listener;
    }

    @Override
    public void onClick(View view) {
        if(listenerOnClik!=null){
            listenerOnClik.onClick(view);
        }
    }
}
