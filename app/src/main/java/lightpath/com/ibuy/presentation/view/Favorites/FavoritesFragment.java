package lightpath.com.ibuy.presentation.view.Favorites;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import lightpath.com.ibuy.R;
import lightpath.com.ibuy.data.entity.Favorite;
import lightpath.com.ibuy.presentation.model.Adapters.FavoriteAdapter;

public class FavoritesFragment extends Fragment {
    private Context context;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private ArrayList<Favorite> favoritesArrayList;

    private OnFragmentInteractionListener mListener;

    public FavoritesFragment(Context context) {
        this.context = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_favorites, container, false);

        recyclerView=(RecyclerView)view.findViewById(R.id.favorites_rv);
        linearLayoutManager= new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        favoritesArrayList=new ArrayList<Favorite>();
        favoritesArrayList.add(new Favorite("Prenda 1","180 Bs."));
        favoritesArrayList.add(new Favorite("Prenda 2","280 Bs."));
        favoritesArrayList.add(new Favorite("Prenda 3","380 Bs."));
        favoritesArrayList.add(new Favorite("Prenda 4","480 Bs."));
        favoritesArrayList.add(new Favorite("Prenda 5","180 Bs."));
        favoritesArrayList.add(new Favorite("Prenda 6","280 Bs."));
        favoritesArrayList.add(new Favorite("Prenda 7","380 Bs."));
        favoritesArrayList.add(new Favorite("Prenda 8","480 Bs."));
        FavoriteAdapter adapter = new FavoriteAdapter(favoritesArrayList);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"item: "+recyclerView.getChildPosition(view),Toast.LENGTH_LONG).show();
                //Intent i=new Intent(getContext(), RegistroComandaActivity.class);
                //startActivity(i);
            }
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
