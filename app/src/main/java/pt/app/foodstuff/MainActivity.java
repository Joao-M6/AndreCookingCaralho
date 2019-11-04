package pt.app.foodstuff;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import pt.app.foodstuff.Fragments.FavoritesFragment;
import pt.app.foodstuff.Fragments.FridgeFragment;
import pt.app.foodstuff.Fragments.HelpFragment;
import pt.app.foodstuff.Fragments.HomeFragment;
import pt.app.foodstuff.Fragments.MealPlanningFragment;
import pt.app.foodstuff.Fragments.ProfileFragment;
import pt.app.foodstuff.Fragments.RecipeFragment;
import pt.app.foodstuff.Fragments.SettingsFragment;
import pt.app.foodstuff.Fragments.ShoppingListFragment;
import pt.app.foodstuff.Fragments.SugestionsFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Pôr o nosso toolbar como a action bar normal
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        final NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Passamos drawer e toolbar porque são as duas views que queremos conectadas e sincronizadas
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        final View headerview=navigationView.getHeaderView(0);
        View txtview_edit = headerview.findViewById(R.id.nav_header);

        txtview_edit.setOnClickListener(new View.OnClickListener() {
            @Override    public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ProfileFragment()).commit();

                navigationView.setCheckedItem(R.id.nav_profile);
                drawer.closeDrawer(GravityCompat.START);
            }
        });

        //Ao iniciar a aplicacao queremos ter a pagina inicial a comecar
        //Impede que a app volta a pagina inicial se houver algum conflito
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new RecipeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                //Abrir o fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HomeFragment()).commit();
                break;
            case R.id.nav_recipes:
                //Abrir o fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new RecipeFragment()).commit();
                break;
            case R.id.nav_fridge:
                //Abrir o fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FridgeFragment()).commit();
                break;
            case R.id.nav_shopping_list:
                //Abrir o fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ShoppingListFragment()).commit();
                break;
            case R.id.nav_meal_planning:
                //Abrir o fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MealPlanningFragment()).commit();
                break;
            case R.id.nav_favorites:
                //Abrir o fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FavoritesFragment()).commit();
                break;
            case R.id.nav_sugestions:
                //Abrir o fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SugestionsFragment()).commit();
                break;
            case R.id.nav_profile:
                //Abrir o fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ProfileFragment()).commit();
                break;
            case R.id.nav_help:
                //Abrir o fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HelpFragment()).commit();
                break;
            case R.id.nav_settings:
                //Abrir o fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SettingsFragment()).commit();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);

        //return false diz que nenhum item e selecionado
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
