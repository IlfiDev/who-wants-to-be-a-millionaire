package ru.mirea.whowantstobeamillionaire.view;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import ru.mirea.whowantstobeamillionaire.R;

public class MainFragment extends Fragment {

    List<Question> questions = MainActivity.question;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Test
    public void getQuestionTest(){
        String expectedAnswer = "rightAnswer";
        String realAnswer = "";
        Assert.assertEquals(expectedAnswer, realAnswer);
    }

    @Test
    private void getFailedDialog() {
        Boolean isFail = false;
        Boolean getFail = null;
        Assert.assertEquals(isFail, getFail);
    }

}