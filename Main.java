package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {


    static String [] tab ;    // board where we will play
    static String tour ;      // varriable to know who will play each time


    static String checkWin() {
        for(int i = 0; i < 8; i++) {
            String ligne = null;

            switch(i) {  // each iteration the program recheck the status of the tab if the player in action won or still not
                case 0:
                    ligne = tab[0] + tab[1] + tab[2];
                    break;
                case 1:
                    ligne = tab[3] + tab[4] + tab[5];
                    break;
                case 2:
                    ligne = tab[6] + tab[7] + tab[8];
                    break;
                case 3:
                    ligne = tab[0] + tab[3] + tab[6];
                    break;
                case 4:
                    ligne = tab[1] + tab[4] + tab[7];
                    break;
                case 5:
                    ligne = tab[2] + tab[5] + tab[8];
                    break;
                case 6:
                    ligne = tab[0] + tab[4] + tab[8];
                    break;
                case 7:
                    ligne = tab[2] + tab[4] + tab[6];
                    break;

            }

            if (ligne.equals("XXX")) {
                return "X" ;
            }

            if (ligne.equals("OOO")) {
                return "O" ;
            }
        }

        for(int i = 0 ; i < 9 ; i++) {
            if (Arrays.asList(tab).contains((String.valueOf(i+1)))) {
                break ;
            }
            else if (i == 8) {
                return "draw" ; // if we arrive to 8 actions with no winner
            }
        }

        System.out.println(
                tour + "'s turn \n ; " +
                        "enter tour next move "
                        + tour + " in:");
        return null;

    }

    static void printTab() { // it prints the table
        System.out.println("|___|___|___|");
        System.out.println("| " + tab[0] + " | " + tab[1] + " | " + tab[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + tab[3] + " | " + tab[4] + " | " + tab[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + tab[6] + " | " + tab[7] + " | " + tab[8] + " |");
        System.out.println("|___|___|___|");
    }





    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in) ;
        tab = new String[9] ;
        tour = "X" ;
        String winner = null ;

        for(int i =0; i < 9; i++) {
            tab[i] = String.valueOf(i+1) ;
        }
        System.out.println("Welcome to  XO game.");
        printTab();

        System.out.println(
                "X will play first. Enter your next move to place X :");
        while (winner == null) {
            int numInput;

            try { // if the player enters somthing else than 1,2,3,4,5,6,7,8,9
                numInput = in.nextInt();
                if (!(numInput > 0 && numInput <= 9)) {
                    System.out.println(
                            "Invalid input; re-enter slot number:");
                    continue;
                }
            }
            catch (InputMismatchException e) {
                System.out.println(
                        "Invalid input; re-enter slot number:");
                continue;
            }

            if (tab[numInput - 1].equals(String.valueOf(numInput))) {
                tab[numInput-1] = tour ;

                if (tour == "X") {
                    tour = "O" ;
                }
                else {
                    tour = "X" ;
                }

                printTab();
                winner = checkWin() ;
            }
            else {
                System.out.println("Slot already taken; re-enter slot number:");
            }
            }

        if (winner.equalsIgnoreCase("draw")) {
            System.out.println(
                    "It's a draw! Thanks for playing.");
        }

        else {
            System.out.println(
                    "Congrats! " + winner
                            + "'s  won! I hope you enjoyed our game");
        }


        }


    }

