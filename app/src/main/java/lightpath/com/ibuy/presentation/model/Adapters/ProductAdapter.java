package lightpath.com.ibuy.presentation.model.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import lightpath.com.ibuy.R;
import lightpath.com.ibuy.presentation.model.Entities.ItemProductHolder;
import lightpath.com.ibuy.presentation.model.Entities.Product;

/**
 * Created by LUIS on 06/03/2017.
 */

public class ProductAdapter  extends RecyclerView.Adapter<ItemProductHolder> implements View.OnClickListener{
    ArrayList<Product> productsArray;
    private View.OnClickListener listenerOnClik;
    Context context;
    public ProductAdapter(ArrayList<Product> postsArray,Context context){
        this.productsArray= postsArray;
        this.context=context;
    }

    public ItemProductHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        v.setOnClickListener(this);
        ItemProductHolder pvh = new ItemProductHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ItemProductHolder holder, int position) {
        holder.lblName.setText(productsArray.get(position).name);
        holder.lblPrice.setText(productsArray.get(position).price);
        holder.lblSize.setText(productsArray.get(position).size);
        Glide.with(context).load(productsArray.get(position).image).into(holder.imgImage);
    }

    @Override
    public int getItemCount() {
        return productsArray.size();
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
