package model;

import java.util.ArrayList;

/**
 * A 6 * 6 Mega Tic Tac Toe implementation of Board.
 * ­ "Connection" length: 3
 * ­ Board size: 8x8
 * ­ Acceptable "connection" directions: top­to­bottom, left­to­right.
 * ­ Acceptable spaces: any available space that is not claimed already.
 */
public class MegaTicTacToeBoard extends Board {
    @Override
    public ArrayList<Space> validSpaceList() {
        ArrayList<Space> result = new ArrayList<Space>();
        for (int i = 0; i < this.getSize(); i++) {
            for (int j = 0; j < this.getSize(); j++) {
                if (this.getSpaces()[i][j].isValid()) {
                    result.add(this.getSpaces()[i][j]);
                }
            }
        }
        return result;
    }

    public MegaTicTacToeBoard() {
        this.setSize(8);
        this.setCurrentPlayer('A');
        this.setGameOver(false);
        Space[][] spaces = new Space[this.getSize()][this.getSize()];
        for (int i = 0; i < spaces.length; i++) {
            for (int j = 0; j < spaces[i].length; j++) {
                spaces[i][j] = new Space();
            }
        }
        this.setSpaces(spaces);
    }

    @Override
    public void runOnce() {
        if (this.getCurrentPlayer() == 'A') {
            this.setCurrentPlayer('B');
        } else {
            this.setCurrentPlayer('A');
        }
        if (checkWin() || (validSpaceList().size() == 0)) {
            this.setGameOver(true);
        }
    }

    @Override
    public boolean checkWin() {
        for (int i = 0; i < this.getSize() - 2; i++) {
            for (int j = 0; j < this.getSize() - 2; j++) {
                if (checkWinRow(i, j) || checkWinColumn(i, j) ||
                        checkWinDiagonal(i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkWinColumn(int row, int col) {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(this.getSpaces()[row][i].getToken(), this.getSpaces
                    ()[row + 1][i].getToken(), this.getSpaces()[row + 2][i]
                    .getToken())
                    == true) {
                return true;
            }
        }
        return false;
    }

    private boolean checkWinRow(int row, int col) {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(this.getSpaces()[i][col].getToken(), this.getSpaces
                    ()[i][col + 1].getToken(), this.getSpaces()[i][col + 2]
                    .getToken())
                    == true) {
                return true;
            }
        }
        return false;
    }

    private boolean checkWinDiagonal(int row, int col) {
        return (checkRowCol(this.getSpaces()[row][col].getToken(), this
                .getSpaces
                        ()[row + 1][col + 1].getToken(), this.getSpaces()[row +
                2][col + 2].getToken())
                == true) ||
                (checkRowCol(this.getSpaces()[row][col + 2].getToken(),
                        this.getSpaces()[row + 1][col + 1].getToken(), this
                                .getSpaces()
                                [row + 2][col]
                                .getToken())
                        == true);
    }

    private boolean checkRowCol(char space1, char space2, char space3) {
        return ((space1 != '-') && (space1 == space2) && (space2 == space3));
    }

}
