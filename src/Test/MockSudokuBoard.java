package Test;

import Main.SudokuBoard;
import Main.SudokuIterator;

public class MockSudokuBoard implements SudokuBoard {
    private int[][] board;

    public MockSudokuBoard(int[][] board) {
        this.board = board;
    }

    @Override
    public int getSize() {
        return board.length;
    }

    @Override
    public int getValueAt(int row, int col) {
        return board[row][col];
    }

    @Override
    public void setValueAt(int row, int col, int value) {
        board[row][col] = value;
    }

    @Override
    public SudokuIterator iterator() {
        return null;
    }
}

