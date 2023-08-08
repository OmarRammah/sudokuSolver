package Main;

public class VariableSizeSudokuBoard implements SudokuBoard {
    private int[][] board;

    @Override
    public SudokuIterator iterator() {
        return new VariableSizeSudokuIterator(this);
    }


    public VariableSizeSudokuBoard(int size) {
        // Initialize the Sudoku board with the given size
        board = new int[size][size];
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
}

