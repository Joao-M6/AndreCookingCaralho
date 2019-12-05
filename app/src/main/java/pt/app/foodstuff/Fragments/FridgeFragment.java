package pt.app.foodstuff.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import pt.app.foodstuff.R;

public class FridgeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fridge, container, false);

        final View.OnClickListener mListener = new View.OnClickListener() {
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button_fridge_options_temp:
                        getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new RecipeOptionsFragment()).addToBackStack(null).commit();
                        break;
                }
            }
        };

        view.findViewById(R.id.button_fridge_options_temp).setOnClickListener(mListener);

        return view;
    }
}
