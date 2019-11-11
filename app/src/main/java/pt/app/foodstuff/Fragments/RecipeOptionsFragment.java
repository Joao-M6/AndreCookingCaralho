package pt.app.foodstuff.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pt.app.foodstuff.R;

public class RecipeOptionsFragment extends Fragment {

    TextView setTime;
    DialogFragment newFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe_options, container, false);

        setTime = (TextView) view.findViewById(R.id.recipe_options_textClock);

        setTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Show time dialog
                newFragment  = new TimePickerFragment(setTime);
                //newFragment.show(getActivity().getFragmentManager(), DIALOG_TIME);
                newFragment.show(getFragmentManager(), "Time Picker");

            }
        });

        return view;
    }
}
