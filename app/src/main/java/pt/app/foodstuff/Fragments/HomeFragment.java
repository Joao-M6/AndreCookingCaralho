package pt.app.foodstuff.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import pt.app.foodstuff.R;

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        final View.OnClickListener hListener = new View.OnClickListener() {
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button_home_cooking:
                        getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new FridgeFragment()).addToBackStack(null).commit();
                        break;
                    case R.id.button_home_shopping_list:
                        getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new ShoppingListFragment()).addToBackStack(null).commit();
                        break;
                    case R.id.button_home_meal_planning:
                        getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new MealPlanningFragment()).addToBackStack(null).commit();
                        break;
                    case R.id.button_home_sugestions:
                        getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new SugestionsFragment()).addToBackStack(null).commit();
                        break;
                }
            }

        };

        view.findViewById(R.id.button_home_cooking).setOnClickListener(hListener);
        view.findViewById(R.id.button_home_shopping_list).setOnClickListener(hListener);
        view.findViewById(R.id.button_home_meal_planning).setOnClickListener(hListener);
        view.findViewById(R.id.button_home_sugestions).setOnClickListener(hListener);

        return view;
    }

}
