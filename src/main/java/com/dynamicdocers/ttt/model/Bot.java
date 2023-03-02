package com.dynamicdocers.ttt.model;

import java.util.ArrayList;
import java.util.Random;
/**
 This class represents a bot that can make a move on a Tic Tac Toe board.
 */
public class Bot {
    /**
     * This method makes a move for the bot on the given Tic Tac Toe board.
     * @param ticTacToeBoard the Tic Tac Toe board on which to make a move
     * @param symbol the symbol that the bot should use for its move (either 'x' or 'o')
     */
    public void makeMove(Board ticTacToeBoard,char symbol) {
        // Create a new Random object
        Random rand = new Random();

        // Find all the empty squares on the board
        ArrayList<int[]> emptySquares = new ArrayList<int[]>();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (ticTacToeBoard.getBoard()[row][col] == '-') {
                    emptySquares.add(new int[] {row, col});
                }
            }
        }
        // If there are no empty squares, return
        if (emptySquares.isEmpty()) {
            return;
        }
        // Choose a random empty square and place the bot's symbol there
        int[] randomSquare = emptySquares.get(rand.nextInt(emptySquares.size()));
        ticTacToeBoard.updateBoard(randomSquare[0], randomSquare[1], symbol);
    }
}


