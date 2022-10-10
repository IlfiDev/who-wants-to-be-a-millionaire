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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        NavController navHostController;
        navHostController = Navigation.findNavController(this, R.id.nav_host);

        ArrayList<Question> question = new ArrayList<>();
        question.add(new Question("Как называют беспилотный летательный аппарат?", "Дрон", new ArrayList<String>(Arrays.asList("Дрон", "Махаон", "Десиптикон")), 1));
        question.add(new Question("В какой игре не используют мяч?", "Керлинг", new ArrayList<String>(Arrays.asList("Волейбол", "Футболл", "Теннис")), 2));
        question.add(new Question("Что в сказках было семимильным?", "Ковёр", new ArrayList<String>(Arrays.asList("Одежда", "Сапоги", "Мотоцикл")), 3));
        question.add(new Question("Какое слово трижды встречается в романе «Евгений Онегин»?", "Сплин", new ArrayList<String>(Arrays.asList("Аквариум", "Кино", "Кудж")), 4));
        question.add(new Question("Кто не шахматист?", "Уле-Эйнар Бьорндален", new ArrayList<String>(Arrays.asList("Ян Непомнящий", "Магнус Карлсен", "Сергей Карякин")), 5));
        question.add(new Question("Какой элемент получил свое название из-за синей линии в его спектре?", "Индий", new ArrayList<String>(Arrays.asList("Родий", "Цезий", "Нептуний")), 6));
        question.add(new Question("Участники какой группы записали песню, которую случайно нашли на чердаке дома в Великобритании в ноябре 2021 года?", "Битлз", new ArrayList<String>(Arrays.asList("Квин", "Металлика", "Сектор Газа")), 7));
        question.add(new Question("В каком из этих фильмов Марка Захарова снимался Александр Абдулов, но не снимался Олег Янковский?", "12 стульев", new ArrayList<String>(Arrays.asList("Дом, который построил Свифт", "Обыкновенное чудо", "Убить дракона")), 8));
        question.add(new Question("Что итальянцы называют «мадоннари»?", "Рисунки на асфальте", new ArrayList<String>(Arrays.asList("Вуаль", "Сорт яблок", "Привет, друзья!")), 9));
        question.add(new Question("Какой мультфильм Уолт Дисней передал Советскому Союзу в честь победы во Второй мировой войне?", "Бэмби", new ArrayList<String>(Arrays.asList("Белоруссия", "Дамбо", "Привет, друзья!")), 10));
        question.add(new Question("Какая церковь находится на территории Московского Кремля?", "Иоанна Лествичника", new ArrayList<String>(Arrays.asList("Симеона Столпника", "Феодора Стратилата", "Александра Пересвета")), 11));
        question.add(new Question("Из чего на масленичном фестивале во французском городе Ментоне делают огромные скульптуры?", "Из цитрусов", new ArrayList<String>(Arrays.asList("Из тыквы", "Из яблока", "Из сыра")), 12));
        question.add(new Question("Какой из этих минералов обладает большей твердостью по шкале Мооса?", "Аквамарин", new ArrayList<String>(Arrays.asList("Опал", "Кварц", "Тигровый глаз")), 13));
        question.add(new Question("Как называют специалиста, избавляющего лес от болезней и вредителей?", "Лесопатолог", new ArrayList<String>(Arrays.asList("Лесник", "Лесовик", "Леший")), 14));
        question.add(new Question("Лучшее пиво по мнению МИРЭАшников?", "Честер", new ArrayList<String>(Arrays.asList("Козёл", "Балтика", "Хамовники Пильзенское")), 1));
    }
}