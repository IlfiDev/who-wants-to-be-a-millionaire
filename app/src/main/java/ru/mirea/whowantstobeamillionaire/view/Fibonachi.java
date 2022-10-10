package ru.mirea.whowantstobeamillionaire.view;

public class Fibonachi{
    public static int getFibonachi(int index) {


        int num0 = 1000;
        int num1 = 2000;
        int num2 = 0;


        System.out.print(num0 + " " + num1 + " ");
        for(int i = 3; i <= index; i++){
            num2 = num0 + num1;


            System.out.print(num2 + " ");


            num0 = num1;
            num1 = num2;
        }
        return num2;
    }
}

