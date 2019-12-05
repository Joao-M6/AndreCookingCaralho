package pt.app.foodstuff.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import pt.app.foodstuff.R;

public class SugestionsFragment extends Fragment {

    FragmentTransaction fragmentTransaction;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_sugestions, container, false);

        final View.OnClickListener mListener = new View.OnClickListener() {
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button_sugestions_my_recipes:
                        getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new SugestionsMyRecipesFragment()).addToBackStack(null).commit();
                        break;
                    case R.id.button_sugestions_friends_recipes:
                        getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new SugestionsFriendsFragment()).addToBackStack(null).commit();
                        break;
                    case R.id.button_sugestions_popular_recipes:
                        getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new SugestionsPopularFragment()).addToBackStack(null).commit();
                        break;
                    case R.id.button_sugestions_tematic_recipes:
                        getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new SugestionsTematicFragment()).addToBackStack(null).commit();
                        break;
                    case R.id.button_sugestions_supermarkets:
                        getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new SugestionsSupermarketFragment()).addToBackStack(null).commit();
                        break;
                }
            }

        };

        view.findViewById(R.id.button_sugestions_my_recipes).setOnClickListener(mListener);
        view.findViewById(R.id.button_sugestions_friends_recipes).setOnClickListener(mListener);
        view.findViewById(R.id.button_sugestions_popular_recipes).setOnClickListener(mListener);
        view.findViewById(R.id.button_sugestions_tematic_recipes).setOnClickListener(mListener);
        view.findViewById(R.id.button_sugestions_supermarkets).setOnClickListener(mListener);

        return view;
    }
}
