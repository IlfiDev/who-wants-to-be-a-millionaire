package ru.mirea.whowantstobeamillionaire.view;

import java.util.List;

public class Fibonachi{
    public static int getFibonachi(int index) {

        //Объявляем переменные при известных первых двух:
        int num0 = 1000;
        int num1 = 2000;
        int num2 = 0;

        //Первые две переменные выводим вне цикла:
        System.out.print(num0 + " " + num1 + " ");
        for(int i = 3; i <= index; i++){
            num2 = num0 + num1;

            //Каждый следующий элемент выводим в цикле:
            System.out.print(num2 + " ");

            //Предыдущим двум переменным присваиваем новые значения:
            num0 = num1;
            num1 = num2;
        }
        return num2;
    }
}

