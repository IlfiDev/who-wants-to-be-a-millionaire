package ru.mirea.whowantstobeamillionaire.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Objects;

import ru.mirea.whowantstobeamillionaire.R;

public class StartFragment extends Fragment {

    Button next_button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_start, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        next_button = (Button) getView().findViewById(R.id.next_button);
        next_button.setOnClickListener(v -> Navigation.findNavController(getView()).navigate(R.id.action_startFragment_to_mainFragment));
    }
}