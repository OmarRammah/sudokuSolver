package Main;

import static Main.SudokuValidator.isValidSudoku;

public class BacktrackingSudokuSolver implements SudokuSolver {

    @Override
    public boolean solveSudoku(SudokuBoard board) {
        return solveSudokuRecursive(board);
    }

    /**
     * Solves the sudoku recursively using the backtracking method.
     * @param board: Board to Solve
     * @return Boolean value; true if the sudoku is solved, false otherwise.
     */
    private boolean solveSudokuRecursive(SudokuBoard board) {
        // Implement the backtracking algorithm to solve the Sudoku recursively
        // The algorithm will work with a Sudoku board of any size

        if (!isValidSudoku(board)) {
            return false;
        }

        int N = board.getSize(); // Assume the Sudoku board is square (N x N)
        int[] emptyCell = findEmptyCell(board);

        // If there are no empty cells, the Sudoku is solved
        if (emptyCell == null) {
            return true;
        }

        int row = emptyCell[0];
        int col = emptyCell[1];

        // Try placing numbers 1 to N in the empty cell
        for (int num = 1; num <= N; num++) {
            if (isValidMove(board, row, col, num)) {
                board.setValueAt(row, col, num);

                // Recursively solve the remaining Sudoku
                if (solveSudokuRecursive(board)) {
                    return true;
                }

                // If the current placement leads to an incorrect solution, reset it
                board.setValueAt(row, col, 0);
            }
        }

        // If no number can be placed in the current cell, backtrack
        return false;
    }

    private int[] findEmptyCell(SudokuBoard board) {
        // Helper method to find the first empty cell in the Sudoku board
        // Returns the row and column indices of the empty cell, or null if not found

        int N = board.getSize(); // Assume the Sudoku board is square (N x N)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board.getValueAt(i, j) == 0) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private boolean isValidMove(SudokuBoard board, int row, int col, int num) {
        // Helper method to check if placing 'num' in the given cell (row, col) is valid

        int N = board.getSize(); // Assume the Sudoku board is square (N x N)

        // Check if the number is not present in the current row and column
        for (int i = 0; i < N; i++) {
            if (board.getValueAt(row, i) == num || board.getValueAt(i, col) == num) {
                return false;
            }
        }

        // Check if the number is not present in the square subgrid
        int sqrtN = (int) Math.sqrt(N);
        int startRow = row - row % sqrtN;
        int startCol = col - col % sqrtN;
        for (int i = 0; i < sqrtN; i++) {
            for (int j = 0; j < sqrtN; j++) {
                if (board.getValueAt(startRow + i, startCol + j) == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
