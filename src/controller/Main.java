package controller;

import model.Board;
import model.ConnectFourBoard;
import model.MegaTicTacToeBoard;
import model.Space;
import model.TicTacToeBoard;
import view.BoardGUI;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Contains the main method of the game.
 */
public class Main {

    /**
     * Just call different method to play different games. Have fun! :-)
     */
    public static void main(String[] args) throws Exception {
        playConnectFour();
    }

    public static void playTicTacToe() throws Exception {
        TicTacToeBoard board = new TicTacToeBoard();
        BoardGUI<TicTacToeBoard> gui = new BoardGUI<>(board);
        run(board, gui);
    }

    public static void playMegaTicTacToe() throws Exception {
        MegaTicTacToeBoard board = new MegaTicTacToeBoard();
        BoardGUI<MegaTicTacToeBoard> gui = new BoardGUI<>(board);
        run(board, gui);
    }

    public static void playConnectFour() throws Exception {
        ConnectFourBoard board = new ConnectFourBoard();
        BoardGUI<ConnectFourBoard> gui = new BoardGUI<>(board);
        run(board, gui);
    }

    private static void run(Board board, BoardGUI gui) throws Exception {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        while (!board.isGameOver()) {
            board.runOnce();
            gui.render();
            input.nextLine();
            ArrayList<Space> validSpaces = board.validSpaceList();
            Space next = validSpaces.get(random.nextInt(validSpaces.size()));
            board.take(next);
        }
    }
}
