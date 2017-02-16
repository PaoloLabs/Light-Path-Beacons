package lightpath.com.ibuy.presentation.view.Principal;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import lightpath.com.ibuy.R;
import lightpath.com.ibuy.presentation.view.About.AboutFragment;
import lightpath.com.ibuy.presentation.view.Favorites.FavoritesFragment;
import lightpath.com.ibuy.presentation.model.Adapters.ViewPagerAdapter;
import lightpath.com.ibuy.presentation.view.QReader.QReaderFragment;
import lightpath.com.ibuy.presentation.view.Receiver.ReceiverFragment;

public class PrincipalActivity extends AppCompatActivity implements PrincipalView{
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        initializeComponents();
        renderTabView();
    }

    @Override
    public void renderTabView() {
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new ReceiverFragment(PrincipalActivity.this), "Rec");
        viewPagerAdapter.addFragments(new FavoritesFragment(PrincipalActivity.this), "Fav");
        viewPagerAdapter.addFragments(new QReaderFragment(PrincipalActivity.this), "QR");
        viewPagerAdapter.addFragments(new AboutFragment(PrincipalActivity.this), "About");

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.mipmap.ic_launcher);
        tabLayout.getTabAt(1).setIcon(R.mipmap.ic_launcher);
        tabLayout.getTabAt(2).setIcon(R.mipmap.ic_launcher);
        tabLayout.getTabAt(3).setIcon(R.mipmap.ic_launcher);
    }

    @Override
    public void showMessage() {

    }

    @Override
    public void initializeComponents() {
        tabLayout = (TabLayout) findViewById(R.id.principal_tabLayout);
        viewPager = (ViewPager) findViewById(R.id.principal_viewPager);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new FavoritesFragment(PrincipalActivity.this), "Fav");
        viewPagerAdapter.addFragments(new FavoritesFragment(PrincipalActivity.this), "Fav");
        viewPagerAdapter.addFragments(new FavoritesFragment(PrincipalActivity.this), "Fav");
        viewPagerAdapter.addFragments(new FavoritesFragment(PrincipalActivity.this), "Fav");

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.mipmap.ic_launcher);
        tabLayout.getTabAt(1).setIcon(R.mipmap.ic_launcher);
        tabLayout.getTabAt(2).setIcon(R.mipmap.ic_launcher);
        tabLayout.getTabAt(3).setIcon(R.mipmap.ic_launcher);
    }
}
