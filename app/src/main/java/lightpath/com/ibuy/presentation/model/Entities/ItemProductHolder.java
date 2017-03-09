package lightpath.com.ibuy.presentation.model.Entities;

import android.media.Image;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import lightpath.com.ibuy.R;

/**
 * Created by LUIS on 06/03/2017.
 */

public class ItemProductHolder extends RecyclerView.ViewHolder {
    public TextView lblName;
    public TextView lblPrice;
    public TextView lblSize;
    public ImageView imgImage;

    public ItemProductHolder(View itemView) {
        super(itemView);
        lblName=(TextView)itemView.findViewById(R.id.item_product_txtName);
        lblSize=(TextView)itemView.findViewById(R.id.item_product_txtSize);
        lblPrice=(TextView)itemView.findViewById(R.id.item_product_txtCosto);
        imgImage=(ImageView) itemView.findViewById(R.id.item_product_imgImage);
    }
}
