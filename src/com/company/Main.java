package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {



    public static void main(String[] args) throws Exception {

       while(true) {

           Scanner in = new Scanner(System.in);
           String expression = in.nextLine();
           if(expression.equals("exit")) {
               System.out.println("You're out");
               break;
           }
           String[] expression_array = expression.split(" ");
           if (expression_array.length > 3) {
               throw new Exception();
           }
           Map<String, Integer> hashMap = new HashMap<>();
           String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV",
                   "XVI", "XVII", "XVIII", "XIX", "XX"};

           for (int i = 0; i <= 19; i++) {
               hashMap.put(roman[i], i + 1);
           }


           String whatAreNumbers;

           if (expression_array[0].matches("[-+]?\\d+") && expression_array[2].matches("[-+]?\\d+")) {
               whatAreNumbers = "arabic";

           } else if (expression_array[0].matches("[IVXLCDM]+") && expression_array[2].matches("[IVXLCDM]+")) {
               whatAreNumbers = "roman";

           } else {
               throw new Exception();
           }

           int number_one = 0;
           int number_two = 0;
           int number_roman;

           if (whatAreNumbers.equals("arabic")) {
               number_one = Integer.parseInt(expression_array[0]);
               number_two = Integer.parseInt(expression_array[2]);
           }

           switch (expression_array[1]) {
               case "+":
                   if (whatAreNumbers.equals("roman")) {

                       number_roman = hashMap.get(expression_array[0]) + hashMap.get(expression_array[2]);

                       System.out.println(getRomanKey(number_roman, hashMap));
                   } else {
                       System.out.println(number_one + number_two);
                   }
                   break;
               case "-":
                   if (whatAreNumbers.equals("roman")) {
                       number_roman = hashMap.get(expression_array[0]) - hashMap.get(expression_array[2]);
                       System.out.println(getRomanKey(number_roman, hashMap));
                   } else {
                       System.out.println(number_one - number_two);
                   }
                   break;
               case "/":
                   if (whatAreNumbers.equals("roman")) {
                       number_roman = hashMap.get(expression_array[0]) / hashMap.get(expression_array[2]);
                       System.out.println(getRomanKey(number_roman, hashMap));
                   } else {
                       System.out.println(number_one / number_two);
                   }
                   break;
               case "*":
                   if (whatAreNumbers.equals("roman")) {
                       number_roman = hashMap.get(expression_array[0]) * hashMap.get(expression_array[2]);
                       System.out.println(getRomanKey(number_roman, hashMap));
                   } else {
                       System.out.println(number_one + number_two);
                   }
                   break;
           }
       }
    }
    static String getRomanKey(int number, Map<String, Integer> hashMap) {

        Set < Map.Entry < String, Integer >> entrySet = hashMap.entrySet();

        for (Map.Entry<String, Integer> pair : entrySet) {
            if (number == pair.getValue()) {
                return pair.getKey();
            }
        }
        return null;
    }
}
