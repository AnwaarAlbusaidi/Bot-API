package com.dynamicdocers.ttt.model;

public class Board {

    /**
     * Constructs a new Board object with an empty 3x3 grid.
     */
    public Board() {
        board = new char[3][3];
    }
    /**
     * Constructs a new Board object with the provided grid.
     * @param grid a 2D char array representing the initial state of the board
     */
    public Board(char[][] grid) {
        this.board = grid;
    }
    /**
     * Updates the board with the specified symbol at the given row and column.
     * @param row the row of the board to update
     * @param col the column of the board to update
     * @param symbol the symbol to place on the board
     */
    public void updateBoard(int row, int col, char symbol) {
        if (isBoardFull() || checkWinner('x') || checkWinner('o') )
            return;
            else
             board[row][col] = symbol;
    }
    /**
     * Returns the current state of the board.
     * @return a 2D char array representing the current state of the board
     */
    public char[][] getBoard() {
        return board;
    }
    /**
     * Checks if the specified symbol has won the game.
     * @param symbol the symbol to check for a win
     * @return true if the symbol has won, false otherwise
     */
    public boolean checkWinner(char symbol) {
        // Check rows
        for (int row = 0; row < 3; row++) {
            if (getBoard()[row][0] == symbol && getBoard()[row][1] == symbol && getBoard()[row][2] == symbol) {
                return true;
            }
        }

        // Check columns
        for (int col = 0; col < 3; col++) {
            if (getBoard()[0][col] == symbol && getBoard()[1][col] == symbol && getBoard()[2][col] == symbol) {
                return true;
            }
        }

        // Check diagonals
        if (getBoard()[0][0] == symbol && getBoard()[1][1] == symbol && getBoard()[2][2] == symbol) {
            return true;
        }
        if (getBoard()[0][2] == symbol && getBoard()[1][1] == symbol && getBoard()[2][0] == symbol) {
            return true;
        }

        return false;
    }

    /**
     * Checks if the board is full.
     * @return true if the board is full, false otherwise
     */
    public boolean isBoardFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == '\0') {
                    return false;
                } else if (board[row][col] != 'x' && board[row][col] != 'o' && checkWinner('x') == false &&
                        checkWinner('0') == false){
                    return false;
                }
            }
        }
        return true;
    }

    private char[][] board;
}
