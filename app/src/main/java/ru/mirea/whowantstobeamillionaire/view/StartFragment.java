package ru.mirea.whowantstobeamillionaire.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

import ru.mirea.whowantstobeamillionaire.R;

public class StartFragment extends Fragment {

    Button next_button;
    int screen = 0;
    TextView textTitle;
    TextView textDescription;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_start, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        next_button = (Button) getView().findViewById(R.id.next_button);
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (screen){
                    case 0:
                        setText(R.string.rule_title, R.string.rule_description);
                        break;
                    case 1:
                        setText(R.string.bonus_title, R.string.bonus_description);
                        break;
                    case 2:
                        Navigation.findNavController(StartFragment.this.getView()).navigate(R.id.action_startFragment_to_mainFragment);
                        break;
                }
            }
        });
    }

    public void setText (int title, int desk) {
        textTitle = (TextView) getView().findViewById(R.id.hello_text);
        textTitle.setText(title);

        textDescription = (TextView) getView().findViewById(R.id.millioner_title);
        textDescription.setBackgroundResource(R.drawable.name_shape);
        textDescription.setTextSize(16);
        textDescription.setPadding(40, 40, 40, 40);
        textDescription.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
        textDescription.setText(desk);

        next_button.setText("Удачи!");

        screen++;
    }
}