package org.example.GameElements;

import java.util.Scanner;

public class Player {

        private static final Scanner scanner = new Scanner(System.in);

        public static int getPlayerMove(int cols) {
        int col = 0;
        while (true) {
            System.out.println("If you want to exit, enter the 0!");
            System.out.print("Choose a column (1-7): ");
            col =scanner.nextInt();
            if (col>=0 && col<=cols) {
                break;
            }else {
                System.out.println("Invalid input. Please enter a number between 1 and 7.");
            }
        }
        return col;
    }

    public static String Nevmegadas(){
            String jatekos_neve;

            while (true){
                System.out.print("enter your name: ");
                jatekos_neve = scanner.nextLine();
                if (!jatekos_neve.isEmpty()){
                    break;
                }else{
                    System.out.println("invalid username! pls enter your name: ");
                }
            }
            return jatekos_neve;
    }
    }
