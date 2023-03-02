package com.dynamicdocers.ttt.Controller;

import com.dynamicdocers.ttt.model.Board;
import com.dynamicdocers.ttt.model.Bot;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
/**
 Controller class that handles the API endpoints for playing Tic Tac Toe against a bot.
 */
@RestController
@RequestMapping(path = "/api/bot")
public class BotController {
    /**
     * POST endpoint that receives the current state of the Tic Tac Toe board and the symbol of the player
       making the move.
     * Returns the updated state of the board and whether there is a winner or if the game is a tie.
     * @param board a 2D char array representing the current state of the Tic Tac Toe board
     * @param symbolParam the symbol of the player making the move ('x' or 'o')
     * @return a map containing the current state of the board and the winner or a tie message
     */
    @PostMapping
    public Map<String, Object> getTicTacToeBoard(@RequestBody char[][] board,
                                      @RequestParam("symbol") char symbolParam) {
        // create a TicTacToeBoard object and update its state based on the symbol parameter
        Board ticTacToeBoard = new Board(board);
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == symbolParam) {
                    ticTacToeBoard.updateBoard(row, col, symbolParam);
                }
            }
        }

        // create a Bot object and make a move
        Bot bot = new Bot();
        bot.makeMove(ticTacToeBoard,symbolParam);

        // return the current state of the board and the winner
        Map<String, Object> response = new HashMap<>();
        response.put("board", ticTacToeBoard.getBoard());

        // check for a winner
        char winner = '\0';
        if (ticTacToeBoard.checkWinner('x')) {
            winner = 'x';
            response.put("winner: ", winner);
       } else if (ticTacToeBoard.checkWinner('o')) {
            winner = 'o';
            response.put("winner: ", winner);
        }
        // check if the board is full
        else if (ticTacToeBoard.isBoardFull()) {
            response.put("message", "Game is a tie");
        }

        return response;
    }
    /**
     GET endpoint that returns an empty Tic Tac Toe board to start a new game.
     @return a 2D char array representing an empty Tic Tac Toe board
     */
    @GetMapping
    public char[][] makeGrid(){
        char[][] board = new char[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
              board[row][col] = '-';
            }
        }
        return board;
    }
}

