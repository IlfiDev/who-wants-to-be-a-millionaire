package ru.mirea.whowantstobeamillionaire.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;

import ru.mirea.whowantstobeamillionaire.R;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<Question> question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        NavController navHostController;
        navHostController = Navigation.findNavController(this, R.id.nav_host);

        }
}