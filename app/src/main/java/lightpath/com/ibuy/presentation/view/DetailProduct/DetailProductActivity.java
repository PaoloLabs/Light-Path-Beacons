package lightpath.com.ibuy.presentation.view.DetailProduct;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import lightpath.com.ibuy.R;
import lightpath.com.ibuy.presentation.view.Products.ProductsActivity;

public class DetailProductActivity extends AppCompatActivity implements DetailProductView{
    private TextView txtName;
    private TextView txtDetail;
    private TextView txtPrice;
    private ImageView imgImage;
    private TextView txtSizes;
    private Bundle data;
    private FloatingActionButton v_fab[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);
        initializeComponents();
        update_toolbar();
    }

    @Override
    public void initializeComponents() {
        txtName=(TextView)findViewById(R.id.detail_txtName);
        txtDetail=(TextView)findViewById(R.id.detail_txtDetail);
        txtPrice=(TextView)findViewById(R.id.detail_txtPrice);
        imgImage=(ImageView)findViewById(R.id.detail_imgImagen);
        txtSizes=(TextView)findViewById(R.id.detail_txtSizes);
        data=getIntent().getExtras();
        v_fab=new FloatingActionButton[]{(FloatingActionButton)findViewById(R.id.detail_fab1),(FloatingActionButton)findViewById(R.id.detail_fab2),(FloatingActionButton)findViewById(R.id.detail_fab3),(FloatingActionButton)findViewById(R.id.detail_fab4),(FloatingActionButton)findViewById(R.id.detail_fab5),(FloatingActionButton)findViewById(R.id.detail_fab6)};
        readData();
    }

    @Override
    public void readData() {
        txtName.setText(data.getString("name"));
        txtPrice.setText(data.getString("price"));
        txtDetail.setText(data.getString("detail"));
        txtSizes.setText(data.getString("size"));
        Glide.with(this).load(data.getString("image")).into(imgImage);
        String colors[]=data.getString("colors").split("-");
        for (int i=0;i<colors.length;i++){
            v_fab[i].setVisibility(View.VISIBLE);
            v_fab[i].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(colors[i])));
        }
    }

    @Override
    public void addFavorites() {

    }

    @Override
    public void update_toolbar() {
        TextView txtToolBar=(TextView)findViewById(R.id.main_bar_txtBar);
        txtToolBar.setText("Detail");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // TODO Auto-generated method stub
            Intent a = new Intent(DetailProductActivity.this, ProductsActivity.class);
            startActivity(a);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
