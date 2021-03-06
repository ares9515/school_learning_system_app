package my.edu.utar.drawertest.ui;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

import my.edu.utar.drawertest.CreateActivity;
import my.edu.utar.drawertest.UpdateActivity;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private int year, month, day;
    private int mode;

    public DatePickerFragment(int mode) {
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        this.mode = mode;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
        if(mode == 0) {
            ((CreateActivity) getActivity()).onDateSet(year, month, day);
        } else {
            ((UpdateActivity) getActivity()).onDateSet(year, month, day);
        }
    }
}
