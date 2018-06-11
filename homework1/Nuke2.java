package com.homework1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Nuke2 {
    public static void main(String[] args)  throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter a string");
        String inputLine = bufferedReader.readLine();
        String newLine = inputLine.substring(0,1) + inputLine.substring(2);
        System.out.println(newLine);
    }
}
