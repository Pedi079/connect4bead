package org.example.GameElements;

import java.io.*;
import java.util.Arrays;

public class Board {
    private static final String BOARD_FILE_PATH="C:\\Users\\kocse\\OneDrive\\Asztali gép\\connect4bead-master\\board.txt";

    // Tábla felépítése
    public static char[][] boardBuilder(int rows,int cols) {
        char[][] board = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Arrays.fill(board[i],'-'); // Üres hely
            }
        }
        File file=new File(BOARD_FILE_PATH);
        if(file.exists()&&file.length()>0){
            try(BufferedReader reader=new BufferedReader(new FileReader(file))){
                for (int i = 0; i < board[0].length; i++) {
                    String line= reader.readLine();
                    if(line !=null){
                        for (int j = 0; j < Math.min(board.length,line.length()); j++) {
                            board[i][j]=line.charAt(j);
                        }
                    }
                }
            }catch (IOException e){
                System.out.println("Test"+e.getMessage());
            }
        }
        return board;
    }

    // Táblázat kiíratása
    public static void printBoard(char[][] board) {
        System.out.print("  ");
        for (int i = 0; i < board[0].length; i++) {
            System.out.print((char) ('A'+i)+" ");//Ez az oszlop betűinek kiíratása
        }
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.print((i+1)+" ");// Sorok előtti sorszám kiíratása
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]+" ");// Tábla kiíratása ez egy 2D -s tömb
            }
            System.out.println();
        }
    }
    public static void gameContinue(char[][] board){
     try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOARD_FILE_PATH))){
         for (char[] row : board){
             writer.write(new String(row));
             writer.newLine();
         }
     }catch (IOException e){
         System.out.println("Failed to load the game position: "+e.getMessage());
     }
    }

    public static void fileContentRemover() {
        try (FileWriter writer = new FileWriter(BOARD_FILE_PATH, false)) {
        } catch (IOException e) {
            System.out.println("Error while deleting file contents: " + e.getMessage());////
        }
    }
}
