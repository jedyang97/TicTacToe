package view;

import model.Board;

/**
 * The GUI to render Board
 */
public class BoardGUI<T extends Board> {

    private Board board;

    public BoardGUI(T board) {
        this.setBoard(board);
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void render() {
        for (int i = 0; i < this.board.getSize(); i++) {
            for (int j = 0; j < this.board.getSize(); j++) {
                System.out.print(this.board.getSpaces()[i][j].getToken());
            }
            System.out.println();
        }
        System.out.println("GAMEOVER? " + this.board.isGameOver());
    }
}
