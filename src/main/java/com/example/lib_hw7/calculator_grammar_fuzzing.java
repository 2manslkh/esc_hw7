package com.example.lib_hw7;

import java.util.Random;

public class calculator_grammar_fuzzing {
    public static void main(String[] args) {
        System.out.println(CalculatorInput.Generate());
    }

    public static class CalculatorInput{
        public static String output = "S";

        public static String Generate(){

            while(fuzz()==true);

            return output;
        }

        private static boolean fuzz(){
            // Returns False if unable to fuzz anymore
            // Returns True if able to fuzz
            Random randint = new Random();


            if (output == "S") {
                output = output.replace("S", "Expr");
            }

            Integer Expr_i = randint.nextInt(3);
//            System.out.println(Expr_i);
            if (Expr_i == 0){
                output = output.replace("Expr", "Expr + Term");
            } else if (Expr_i == 1){
                output = output.replace("Expr", "Expr - Term");
            } else if (Expr_i == 2){
                output = output.replace("Expr", "Term");
            }

            Integer Term_i = randint.nextInt(3);
//            System.out.println(Term_i);
            if (Term_i == 0){
                output = output.replace("Term", "Term * Factor");
            } else if (Term_i == 1){
                output = output.replace("Term", "Term / Factor");
            } else if (Term_i == 2){
                output = output.replace("Term", "Factor");
            }

            Integer Factor_i = randint.nextInt(4);
//            System.out.println(Factor_i);
            if (Factor_i == 0){
                output = output.replace("Factor", "-Integer");
            } else if (Factor_i == 1){
                output = output.replace("Factor", "(Expr)");
            } else if (Factor_i == 2){
                output = output.replace("Factor", "Integer");
            } else if (Factor_i == 3){
                output = output.replace("Factor", "Integer.Integer");
            }

            Integer Integer_i = randint.nextInt(2);
            if (Integer_i == 0){
                output = output.replace("Integer", "Digit");
            } else if (Integer_i == 1){
                output = output.replace("Integer", "IntegerDigit");
            }

            Integer Digit_i = randint.nextInt(10);
            output = output.replace("Digit",Digit_i.toString());

            return output.contains("Expr") || output.contains("Term") || output.contains("Factor") || output.contains("Integer") || output.contains("Digit");
        }
    }
}


