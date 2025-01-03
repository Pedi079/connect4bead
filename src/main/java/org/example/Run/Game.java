package org.example.Run;

import org.example.GameElements.Board;
import org.example.GameElements.Mechanics;
import org.example.GameElements.Player;
import org.example.HighScore.Database;
import org.example.HighScore.Manager;

public class Game {

    public static void main(String[] args) {

       int rows =6;
       int cols =7;

       char[][] board=Board.boardBuilder(rows,cols);

        Manager manager=new Manager();
        manager.buildDatabase();

        System.out.println("Welcome to Connect4 game");

        String playerName= Player.Nevmegadas();

        System.out.println("Game started");
        Board.printBoard(board);

        boolean gameRun=true;

        while(gameRun){
            int column=Player.getPlayerMove(cols);

            if(column==0){
                Board.gameContinue(board);
                gameRun=false;
            }else{
                if(Mechanics.isValidMove(board,column)){
                    Mechanics.saveSymbolMove(board,column,'Y');
                    Board.printBoard(board);

                    if(Mechanics.winChecker(board,'Y')){
                        System.out.println(playerName+" You win!");
                        manager.applyWin(playerName);
                        Board.fileContentRemover();
                        gameRun=false;
                        continue;
                    }
                }else{
                    System.out.println("Invalid move,try again!");
                    continue;
                }

                int botMove=Mechanics.botMove(board);
                Mechanics.saveSymbolMove(board,botMove,'R');
                Board.printBoard(board);

                if(Mechanics.winChecker(board,'R')){
                    System.out.println("Bot win!");
                    Board.fileContentRemover();
                    gameRun=false;
                }
            }
        }
        System.out.println();
        manager.showHighScores();

    }
}
