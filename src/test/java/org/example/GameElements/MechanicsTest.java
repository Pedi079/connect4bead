package org.example.GameElements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class MechanicsTest {
    private char[][] board;

    @BeforeEach
    void setUp()
    {
        board = new char[6][7];
        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 7; j++)
            {
                board[i][j] = '-';
            }
        }
    }

    @Test
    void testIsValidMoveV()
    {
        assertTrue(Mechanics.isValidMove(board, 4));
    }

    @Test
    void testIsInvalidMove()
    {
        for (int i = 0; i < 6; i++)
        {
            board[i][3] = 'R';
        }
        assertFalse(Mechanics.isValidMove(board, 4));
    }

    @Test
    void testSaveMove()
    {
        Mechanics.saveSymbolMove(board, 1, 'Y');
        assertEquals('Y', board[5][0]);
    }

    @Test
    void enemyMove()
    {
        int column = Mechanics.botMove(board);
        assertTrue(Mechanics.isValidMove(board, column));
    }

    @Test
    void winCheckerHor() {
        board[5][0] = 'Y';
        board[5][1] = 'Y';
        board[5][2] = 'Y';
        board[5][3] = 'Y';
        assertTrue(Mechanics.winChecker(board, 'Y'));
    }

    @Test
    void winCheckerVer() {
        board[0][0] = 'R';
        board[1][0] = 'R';
        board[2][0] = 'R';
        board[3][0] = 'R';
        assertTrue(Mechanics.winChecker(board, 'R'));
    }

    @Test
    void winCheckerDiag() {
        board[0][0] = 'Y';
        board[1][1] = 'Y';
        board[2][2] = 'Y';
        board[3][3] = 'Y';
        assertTrue(Mechanics.winChecker(board, 'Y'));
    }

    @Test
    void winCheckerAntiDiag() {
        board[0][3] = 'R';
        board[1][2] = 'R';
        board[2][1] = 'R';
        board[3][0] = 'R';
        assertTrue(Mechanics.winChecker(board, 'R'));
    }

    @Test
    void testWinCheckerNoWin()
    {
        assertFalse(Mechanics.winChecker(board, 'Y'));
    }
}