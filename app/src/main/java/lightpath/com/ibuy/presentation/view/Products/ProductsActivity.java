package lightpath.com.ibuy.presentation.view.Products;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import lightpath.com.ibuy.R;
import lightpath.com.ibuy.presentation.model.Adapters.ProductAdapter;
import lightpath.com.ibuy.presentation.model.Entities.Product;
import lightpath.com.ibuy.presentation.view.DetailProduct.DetailProductActivity;
import lightpath.com.ibuy.presentation.view.Principal.PrincipalActivity;
import lightpath.com.ibuy.presentation.view.Principal.PrincipalView;

public class ProductsActivity extends AppCompatActivity implements ProductosView {
    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private EditText etxtSearch;
    private Button btnSearch;
    private ArrayList<Product> lstProducts;
    private ArrayList<Product> lstProductsAux;
    FirebaseDatabase base_de_datos;
    DatabaseReference myRef;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        initializeComponents();
        update_toolbar();
        }

    @Override
    public void onLoadData() {
        showProgress();
        myRef.child("products").addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //Product product = dataSnapshot.getValue(Product.class);
                        //Log.e("name::",product.name);
                        for (DataSnapshot productsSnapshot: dataSnapshot.getChildren()){
                            Product p=productsSnapshot.getValue(Product.class);
                            lstProducts.add(p);
                        }
                        Log.e("data::",lstProducts.toString());
                        if(lstProducts.size()>0){
                            ProductAdapter adapter = new ProductAdapter(lstProducts,ProductsActivity.this);
                            adapter.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Product xProduct=lstProducts.get(recyclerView.getChildPosition(view));
                                    navigateToDetailProduct(xProduct.name,xProduct.price,xProduct.image,xProduct.detail,xProduct.size,xProduct.colors);
                                }
                            });
                            recyclerView.setAdapter(adapter);
                        }
                        else{
                            showMessage("No se encontraron Registros");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.e("onCancelled", databaseError.toException().toString());
                    }
                });
        hideProgress();
    }

    @Override
    public void onSelectedProduct() {

    }

    @Override
    public void onSelectedProductSuccess() {

    }

    @Override
    public void onSelectedProductError() {

    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void showMessage(String mensaje) {
        Toast.makeText(ProductsActivity.this,mensaje,Toast.LENGTH_LONG).show();
    }

    @Override
    public void navigateToDetailProduct(String name, String price, String image, String detail, String size, String colors) {
        Intent i=new Intent(ProductsActivity.this, DetailProductActivity.class);
        i.putExtra("name",name);
        i.putExtra("price",price);
        i.putExtra("image",image);
        i.putExtra("detail",detail);
        i.putExtra("size",size);
        i.putExtra("colors",colors);
        startActivity(i);
        finish();
    }

    @Override
    public void update_toolbar() {
        TextView txtToolBar=(TextView)findViewById(R.id.main_bar_txtBar);
        txtToolBar.setText("Shop");
    }

    @Override
    public void navigateToPrincipal() {
        Intent i=new Intent(ProductsActivity.this, PrincipalActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void initializeComponents() {
        lstProducts=new ArrayList<Product>();
        /**
         * to write data
         FirebaseDatabase base_de_datos = FirebaseDatabase . getInstance ();
         DatabaseReference myRef = base_de_datos.getReference ( "mensaje" );
         myRef.setValue ( "Hola, mundo!" );
         */
        base_de_datos = FirebaseDatabase . getInstance ();
        myRef = base_de_datos.getReference ("ClothesBeacon");

        //final String userId = getUid();
        /**
         myRef.child("product").addListenerForSingleValueEvent(
         new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
        Product product = dataSnapshot.getValue(Product.class);
        Log.e("name::",product.name);
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
        Log.e("getUser:onCancelled", databaseError.toException().toString());
        }
        });
         */
        recyclerView=(RecyclerView)findViewById(R.id.products_rv);
        gridLayoutManager= new GridLayoutManager(ProductsActivity.this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        progressBar=(ProgressBar)findViewById(R.id.products_prograssBar);
        etxtSearch=(EditText)findViewById(R.id.products_txtSearch);
        btnSearch=(Button)findViewById(R.id.products_btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String to_search=etxtSearch.getText().toString();
                if(to_search.length()>0){
                    lstProductsAux=new ArrayList<Product>();
                    for(int i=0;i<lstProducts.size();i++){
                        if(lstProducts.get(i).name.contains(to_search)){
                            lstProductsAux.add(lstProducts.get(i));
                        }
                    }
                    if(lstProductsAux.size()>0){
                        ProductAdapter adapter = new ProductAdapter(lstProductsAux,ProductsActivity.this);
                        adapter.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Product xProduct=lstProductsAux.get(recyclerView.getChildPosition(view));
                                navigateToDetailProduct(xProduct.name,xProduct.price,xProduct.image,xProduct.detail,xProduct.size,xProduct.colors);
                            }
                        });
                        recyclerView.setAdapter(adapter);
                    }
                    else{
                        showMessage("No se encontraron Registros");
                    }

                }
            }
        });
        onLoadData();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // TODO Auto-generated method stub
            navigateToPrincipal();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
