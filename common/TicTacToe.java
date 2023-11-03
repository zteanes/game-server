package common;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Class for a representation of a TicTacToe board and the logic for the game
 * to work.
 *
 * @author Zach Eanes
 * @version 11/02/2023
 */
public class TicTacToe implements Game, Serializable {
    /** board for the tic-tac-toe game */
    private XAndO[][] board;

    /** count of the number of turns played */
    private int turnCount;

    /** current player for the board */
    private Player player;

    /**
     * Constructor for a TicTacToe game for a new game.
     */
    public TicTacToe() {
        this.board = new XAndO[3][3];
        this.turnCount = 0;
        this.initBoard();
        this.player = new Player(1, XAndO.X);
    }

    /**
     * Constructor for a TicTacToe game for a game in progress.
     *
     * @param board the board for the game in progress
     * @param cnt   the count of the number of turns played
     */
    public TicTacToe(XAndO[][] board, int cnt) { this.board = board; this.turnCount = cnt; }

    /**
     * Causes the game to play a turn for the given player.
     *
     * @param player the player to play the turn for
     */
    @Override
    public void playTurn(Player player) {
        // TODO
    }

    /**
     * Initializes a board with empty values.
     */
    private void initBoard() {
        // for all the rows of the board, fill the row with empty values
        for (int i = 0; i < 3; i++) { Arrays.fill(board[i], XAndO.EMPTY); }
    }

    /**
     * Sets a piece in a tic-tac-toe board.
     *
     * @param row   the row to place the piece in
     * @param col   the column to place the piece in
     * @param piece the piece to place
     * @return      true if the piece was placed, false otherwise
     */
    public boolean setPiece(int row, int col) {
        if(row < 0 || row > 2 || col < 0 || col > 2) { // out of bounds
            System.out.println("Invalid move, that place is out of bounds. Please try again.");
            return false;
        }
        boolean valid = false; // represents the validity of the move

        if(board[row][col] == XAndO.EMPTY){  // if the space is empty
            board[row][col] = (XAndO) this.player.getPiece(); // place piece and valid true
            this.turnCount++;
            valid = true;

            if (this.turnCount == 9) { // if the board is full
                if(!this.isGameOver()) { // and there is no winner
                    System.out.println("The game is a draw!");
                }
            }else if(this.turnCount >= 5) { // 5 is the earliest a win can occur
                this.isGameOver(); // check if the game is over
            }
        } else { // if the space is not empty
            System.out.println("Invalid move, that place is already occupied. Please try again.");
        }
        return valid;
    }

    /**
     * Method to check if the game is over.
     *
     * @return true if the game is over, false otherwise
     */
    public boolean isGameOver() {
        // call methods to check the rows, columns, and diagonals for a win
        boolean isOver = this.checkRows() || this.checkColumns() || this.checkDiagonals();

        if(isOver) { // if a win is found
            System.out.println("The game is over!");
        }
        return isOver;
    }

    /**
     * Checks the rows of the board for a win.
     *
     * @return true if a win is found, false otherwise
     */
    private boolean checkRows() {
        boolean gameOver = false;
        for(int i = 0; i < 3; i++) { // iterate rows
            // if all three elements of a row are the same, a win is found
            if(board[i][0] == board[i][1] && board[i][1] == board[i][2] &&
               board[i][0] != XAndO.EMPTY) {
                gameOver = true; // set gameOver to true and break loop
                break;
            }
        }
        return gameOver;
    }

    /**
     * Checks the columns of the board for a win.
     *
     * @return true if a win is found, false otherwise
     */
    private boolean checkColumns() {
        boolean gameOver = false;
        for(int i = 0; i < 3; i++) { // iterate columns
            if(board[0][i] == board[1][i] && board[1][i] == board[2][i] &&
               board[0][i] != XAndO.EMPTY) {
                gameOver = true; // set gameOver to true and break loop
                break;
            }
        }
        return gameOver;
    }

    /**
     * Checks the diagonals of the board for a win.
     *
     * @return true if a win is found, false otherwise
     */
    private boolean checkDiagonals() {
        boolean gameOver = false;
        // check top left to bottom right diagonal
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] &&
           board[0][0] != XAndO.EMPTY) {
            gameOver = true;
        // check top right to bottom left diagonal
        } else if(board[0][2] == board[1][1] && board[1][1] == board[2][0] &&
                  board[0][2] != XAndO.EMPTY) {
            gameOver = true;
        }
        return gameOver;
    }

    /**
     * Prints a string representation of the game board.
     */
    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println("+---+---+---+");
            for (int j = 0; j < 3; j++){
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("+---+---+---+");
    }

    /**
     * sets the player for the current turn on the tic-tac-toe board.
     *
     * @param player the player for the current turn
     */
    private void setPlayer(Player player) { this.player = player; }

    /** main method for testing board */
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.initBoard();
        game.printBoard();
        while(!game.isGameOver()) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter row: ");
            int row = scan.nextInt();
            System.out.print("Enter column: ");
            int col = scan.nextInt();
            game.setPiece(row, col);
            game.printBoard();
        }
    }
}
