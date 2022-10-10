package ru.mirea.whowantstobeamillionaire.view;

import android.app.appsearch.GetSchemaResponse;
import android.content.Context;
import android.content.SharedPreferences;
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

    private SharedPreferences pref;
    private final String save_key = "save_key";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        init();

        return inflater.inflate(R.layout.fragment_start, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        next_button = (Button) getView().findViewById(R.id.next_button);
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Судя по всему, pref по умолчанию true, поэтому ведется обратная проверка
                if (pref.getBoolean(save_key, false)) {
                    Navigation.findNavController(StartFragment.this.getView()).navigate(R.id.action_startFragment_to_mainFragment);
                }
                else {
                    switch (screen){
                        case 0:
                            setText(R.string.rule_title, R.string.rule_description);
                            break;
                        case 1:
                            setText(R.string.bonus_title, R.string.bonus_description);
                            break;
                        case 2:
                            pref.edit().putBoolean(save_key, true).apply();

                            next_button.setText("Удачи!");
                            Navigation.findNavController(StartFragment.this.getView()).navigate(R.id.action_startFragment_to_mainFragment);
                            break;
                    }
                }
            }
        });
    }

    private void setText (int title, int desk) {
        textTitle = (TextView) getView().findViewById(R.id.hello_text);
        textTitle.setText(title);

        textDescription = (TextView) getView().findViewById(R.id.millioner_title);
        textDescription.setBackgroundResource(R.drawable.name_shape);
        textDescription.setTextSize(16);
        textDescription.setPadding(40, 40, 40, 40);
        textDescription.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
        textDescription.setText(desk);

        screen++;
    }

    public void init(){
        pref = getContext().getSharedPreferences("Screen", Context.MODE_PRIVATE);
    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}