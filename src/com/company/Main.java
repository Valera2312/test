package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String[] expression_array = in.nextLine().split(" ");
        if(expression_array.length > 3){
             throw new Exception();
        }
        Map<String,Integer> hashMap = new HashMap<String,Integer>();
        String[] roman = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};

        for (int i = 0; i <= 9; i++ ){
            hashMap.put(roman[i],i+1);
        }


        System.out.println(hashMap);
        String whatAreNumbers = "";

        if(expression_array[0].matches("[-+]?\\d+") && expression_array[2].matches("[-+]?\\d+")){
            whatAreNumbers = "arabic";

        } else if(expression_array[0].matches("[IVXLCDM]+") && expression_array[2].matches("[IVXLCDM]+")){
            whatAreNumbers = "roman";

        }else {
            throw new Exception();
        }

        switch (expression_array[1]) {
            case "+":
                if (whatAreNumbers.equals("roman")) {
                    System.out.println(hashMap.get(expression_array[0]) + hashMap.get(expression_array[2]));
                } else {
                    System.out.println(Integer.getInteger(expression_array[0]) + Integer.getInteger(expression_array[2]));
                }
                break;
            case "-":
                if (whatAreNumbers.equals("roman")) {
                    System.out.println(hashMap.get(expression_array[0]) - hashMap.get(expression_array[2]));
                } else {
                    System.out.println(Integer.getInteger(expression_array[0]) - Integer.getInteger(expression_array[2]));
                }
                break;
            case "/":
                if (whatAreNumbers.equals("roman")) {
                    System.out.println(hashMap.get(expression_array[0]) / hashMap.get(expression_array[2]));
                } else {
                    System.out.println(Integer.getInteger(expression_array[0]) / Integer.getInteger(expression_array[2]));
                }
                break;
            case "*":
                if (whatAreNumbers.equals("roman")) {
                    System.out.println(hashMap.get(expression_array[0]) * hashMap.get(expression_array[2]));
                } else {
                    System.out.println(Integer.getInteger(expression_array[0]) * Integer.getInteger(expression_array[2]));
                }
                break;
        }


    }

}
