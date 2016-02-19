package controller;

import model.Board;
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

    public static void main(String[] args) throws Exception {
        playMegaTicTacToe();
    }

    public static void playTicTacToe() throws Exception {
        TicTacToeBoard board = new TicTacToeBoard();
        BoardGUI<TicTacToeBoard> gui = new BoardGUI<>(board);
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

    public static void playMegaTicTacToe() throws Exception {
        MegaTicTacToeBoard board = new MegaTicTacToeBoard();
        BoardGUI<MegaTicTacToeBoard> gui = new BoardGUI<>(board);
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
