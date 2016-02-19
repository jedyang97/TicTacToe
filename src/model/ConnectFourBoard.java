package model;

import java.util.ArrayList;

/**
 * A 6 * 6 Connect Four implementation of Board
 * ­ "Connection" length: 4
 * ­ Board size: 6x6
 * ­ Acceptable "connection" directions: top­to­bottom, left­to­right,
 * diagonally up­and­to­the­right, diagonally up­and­to­the­left.
 * ­ Acceptable spaces: any available space that is not claimed already that
 * is directly above a claimed space or is the bottom space of a column.
 */
public class ConnectFourBoard extends Board {

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

    public ConnectFourBoard() {
        this.setSize(6);
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
    public boolean checkWin() {
        for (int i = 0; i < this.getSize() - 3; i++) {
            for (int j = 0; j < this.getSize() - 3; j++) {
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
                            ()[row + 1][i].getToken(), this.getSpaces()[row +
                            2][i]
                            .getToken(),
                    this.getSpaces()[row + 3][i].getToken())
                    == true) {
                return true;
            }
        }
        return false;
    }

    private boolean checkWinRow(int row, int col) {
        for (int i = 0; i < 4; i++) {
            if (checkRowCol(this.getSpaces()[i][col].getToken(), this.getSpaces
                            ()[i][col + 1].getToken(), this.getSpaces()
                            [i][col + 2]
                            .getToken(),
                    this.getSpaces()[i][col + 3].getToken())
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
                2][col + 2].getToken(), this.getSpaces()[row + 3][col + 3]
                .getToken())
                == true) ||
                (checkRowCol(this.getSpaces()[row][col + 3].getToken(),
                        this.getSpaces()[row + 1][2].getToken(), this
                                .getSpaces()
                                [row + 2][col + 1]
                                .getToken(), this.getSpaces()[row + 3][col]
                                .getToken())
                        == true);
    }

    private boolean checkRowCol(char space1, char space2, char space3, char
            space4) {
        return (space1 != '-') && (space1 == space2) && (space2 == space3) &&
                (space3 == space4);
    }

}
