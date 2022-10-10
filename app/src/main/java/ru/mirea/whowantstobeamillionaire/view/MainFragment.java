package ru.mirea.whowantstobeamillionaire.view;

import android.app.NotificationManager;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import com.google.android.material.dialog.MaterialAlertDialogBuilder;


import ru.mirea.whowantstobeamillionaire.R;

public class MainFragment extends Fragment implements View.OnClickListener{

    List<Question> questions = new QuestionsDataBase().getQuestion();

    Button answerA,
            answerB,
            answerC,
            answerD,
            positive_button,
            negative_button,
            fifty_help_button;
    TextView questionText, questionNum;

    public NotificationManager notificationManager;
    private static final int NOTIFY_ID = 1;
    private static final String CHANNEL_ID = "CHANNEL_ID";
    int randomSeed = 15;

    private short question_id = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        fifty_help_button = view.findViewById(R.id.fifty_help_button);

        helpButton();

        questionText = view.findViewById(R.id.question_text);
        questionNum = view.findViewById(R.id.question_number);
        answerA = view.findViewById(R.id.answer_a_button);
        answerA.setOnClickListener(this);
        answerB = view.findViewById(R.id.answer_b_button);
        answerB.setOnClickListener(this);
        answerC = view.findViewById(R.id.answer_g_button2);
        answerC.setOnClickListener(this);
        answerD = view.findViewById(R.id.answer_v_button);
        answerD.setOnClickListener(this);
        loadQuestion(question_id);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    void loadQuestion(int index) {
        Question question = questions.get(index);
        questionText.setText(question.getQuestion());
        List<String> answers = new ArrayList<>();
        answers.add(question.getWrongAnswers().get(0));
        answers.add(question.getWrongAnswers().get(1));
        answers.add(question.getWrongAnswers().get(2));
        answers.add(question.getRightAnswer());

        int randIndex = new Random().nextInt(4);
        answerA.setText(answers.get(randIndex));
        answers.remove(randIndex);

        randIndex = new Random().nextInt(3);
        answerB.setText(answers.get(randIndex));
        answers.remove(randIndex);

        randIndex = new Random().nextInt(2);
        answerC.setText(answers.get(randIndex));
        answers.remove(randIndex);

        answerD.setText(answers.get(0));

        answerA.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.primary));
        answerA.setClickable(true);

        answerB.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.primary));
        answerB.setClickable(true);

        answerC.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.primary));
        answerC.setClickable(true);

        answerD.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.primary));
        answerD.setClickable(true);

        questionNum.setText(String.valueOf("Вопрос " + (index + 1) + ":"));
    }
    public void onClick(View v) {
        String chosenAnswer = "";
        switch(v.getId()){

            case R.id.answer_a_button:
                chosenAnswer = (String) answerA.getText();
                break;

            case R.id.answer_b_button:
                chosenAnswer = (String) answerB.getText();
                break;
            case R.id.answer_g_button2:
                chosenAnswer = (String) answerC.getText();
                break;
            case R.id.answer_v_button:
                chosenAnswer = (String) answerD.getText();
                break;
        }
        if(answerIsCorrect(chosenAnswer)){
            question_id++;
            loadQuestion(question_id);
        }else{
            failDialog();
        }
    }

    public void helpButton(){
        fifty_help_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fifty_help_button.setBackgroundResource(R.color.inactive_button);
                fifty_help_button.setVisibility(View.INVISIBLE);
                String help_answer = fiftyFiftyHelp(5, questions.get(question_id));

                if (!answerIsCorrect((String) answerA.getText()) && help_answer != answerA.getText()) {
                    answerA.setBackgroundColor(Color.GRAY);
                    answerA.setClickable(false);
                }
                if (!answerIsCorrect((String) answerB.getText()) && help_answer != answerB.getText()) {
                    answerB.setBackgroundColor(Color.GRAY);
                    answerB.setClickable(false);
                }
                if (!answerIsCorrect((String) answerC.getText()) && help_answer != answerC.getText()) {
                    answerC.setBackgroundColor(Color.GRAY);
                    answerC.setClickable(false);
                }
                if (!answerIsCorrect((String) answerD.getText()) && help_answer != answerD.getText()) {
                    answerD.setBackgroundColor(Color.GRAY);
                    answerD.setClickable(false);
                }
            }
        });
    }

    public String fiftyFiftyHelp(int seed, Question question) {
        Random rand = new Random();
        rand.setSeed(seed);

        ArrayList<String> list = question.getWrongAnswers();

        for (int i = 0; i < list.size(); i++){
            Log.i("Gig", list.get(i));
        }

        String answer = list.get(rand.nextInt(2));
        return answer;
    }


    private void failDialog() {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(getContext());
        builder.setBackground(getResources().getDrawable(R.drawable.dialog_shape));
        ConstraintLayout cl = (ConstraintLayout) getLayoutInflater().inflate(R.layout.fail_dialog, null);

        builder.setCancelable(false);
        builder.setView(cl);
        AlertDialog dialog = builder.show();

        positive_button = (Button) cl.findViewById(R.id.positive_button);
        negative_button = (Button) cl.findViewById(R.id.netagive_button);

        positive_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                getActivity().finish();
            }
        });

        negative_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                question_id = 0;
                loadQuestion(question_id);
                dialog.dismiss();
            }
        });


    }

    public boolean answerIsCorrect(String answer) {
        return questions.get(question_id).getRightAnswer().equals(answer);
    }
}