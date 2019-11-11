package pt.app.foodstuff.Fragments;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import java.sql.Time;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    private Fragment currentFragment;
    private String time = "";
    TextView tv;

    TimePickerFragment(TextView textView){
        this.tv = textView;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        int hour = 0;
        int minute = 0;

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    @Override
    public void onTimeSet(TimePicker view, int hour, int minute) {
        time = String.valueOf(hour) + ":" + String.valueOf(minute);
        tv.setText(time);
    }

    public String getTime() {
        return time;
    }

    private void sendResult(int resultCode, Time mTime) {
        if (getTargetFragment() == null)
            return;
        Intent i = new Intent();
        i.putExtra("EXTRA_TIME", mTime);
        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, i);
    }
}
