package lightpath.com.ibuy.presentation.view.Products;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

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
import lightpath.com.ibuy.presentation.view.Principal.PrincipalActivity;

public class ProductsActivity extends AppCompatActivity implements ProductosView {
    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private ArrayList<Product> lstProducts;
    FirebaseDatabase base_de_datos;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        initializeComponents();
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
                                    navigateToDetailProduct(xProduct.name,xProduct.price,xProduct.image,xProduct.detail,xProduct.detail,xProduct.colors);
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

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void showMessage(String mensaje) {

    }

    @Override
    public void navigateToDetailProduct(String name, String price, String image, String detail, String size, String colors) {
        Intent i=new Intent(ProductsActivity.this,ProductsActivity.class);
        i.putExtra("name",name);
        i.putExtra("price",price);
        i.putExtra("image",image);
        i.putExtra("detail",detail);
        i.putExtra("size",size);
        i.putExtra("colors",colors);
        startActivity(i);
    }

    @Override
    public void navigateToPrincipal() {
        Intent i=new Intent(ProductsActivity.this, PrincipalActivity.class);
        startActivity(i);
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
        onLoadData();
    }
}
