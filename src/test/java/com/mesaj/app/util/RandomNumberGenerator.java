package com.mesaj.app.util;

import java.util.Random;

public class RandomNumberGenerator {

    public static String get(){
        String firstNumber = ranmdomNumber(111111111,999999999);
        String secondNumber = ranmdomNumber(11,99);
        return String.format("%s%s",firstNumber, secondNumber);
    }

    public static String ranmdomNumber(int min, int max){
        Random r = new Random();
        return String.valueOf(r.nextInt((max-min)+1)+ min);
    }
}
