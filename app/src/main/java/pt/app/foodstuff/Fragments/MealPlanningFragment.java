package pt.app.foodstuff.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import pt.app.foodstuff.R;

public class MealPlanningFragment extends Fragment {

    CalendarView calendarView;
    TextView tempDate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meal_planning, container, false);

        calendarView = (CalendarView) view.findViewById(R.id.meal_planning_calendarView);
        tempDate = (TextView) view.findViewById(R.id.meal_planning_temp_date);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = dayOfMonth + "/" + month + "/" + year;
                tempDate.setText(date);
            }
        });

        return view;
    }

}
