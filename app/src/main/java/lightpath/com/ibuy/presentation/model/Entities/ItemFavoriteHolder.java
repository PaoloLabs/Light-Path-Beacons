package lightpath.com.ibuy.presentation.model.Entities;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import lightpath.com.ibuy.R;

/**
 * Created by LUIS on 11/02/2017.
 */

public class ItemFavoriteHolder extends RecyclerView.ViewHolder {
    public TextView lblName;
    public TextView lblCost;

    public ItemFavoriteHolder(View itemView) {
        super(itemView);
        lblName=(TextView)itemView.findViewById(R.id.itemFavorites_lblName);
        lblCost=(TextView)itemView.findViewById(R.id.itemFavorites_lblCost);
    }
}