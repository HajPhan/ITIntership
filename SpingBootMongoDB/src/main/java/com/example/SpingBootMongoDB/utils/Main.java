package com.example.SpingBootMongoDB.utils;

import java.util.Random;

public class Main {
    public static void main(String [] args){
        Random rd = new Random();
        int n = 1000000;
        for(int i = 1; i <= n; i++){
            System.err.println(i + " : " + 849+(1000000+rd.nextInt(n)));
        }
        System.err.println("Hello world!");

    }
}
