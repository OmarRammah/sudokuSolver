package Main;

public class SudokuValidator {
    /**
     * Check whether the input board is a valid sudoku board.
     * @param board: input board
     * @return Boolean value of whether the board is valid.
     */
    public static boolean isValidSudoku(SudokuBoard board) {
        int N = board.getSize();

        for (int i = 0; i < N; i++) {
            if (!isValidRow(board, i) || !isValidColumn(board, i) || !isValidSubgrid(board, i)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isValidRow(SudokuBoard board, int row) {
        int N = board.getSize();
        boolean[] used = new boolean[N + 1];

        for (int col = 0; col < N; col++) {
            int num = board.getValueAt(row, col);
            if (num != 0) {
                if (used[num]) {
                    return false;
                }
                used[num] = true;
            }
        }

        return true;
    }

    private static boolean isValidColumn(SudokuBoard board, int col) {
        int N = board.getSize();
        boolean[] used = new boolean[N + 1];

        for (int row = 0; row < N; row++) {
            int num = board.getValueAt(row, col);
            if (num != 0) {
                if (used[num]) {
                    return false;
                }
                used[num] = true;
            }
        }

        return true;
    }

    private static boolean isValidSubgrid(SudokuBoard board, int subgridIndex) {
        int N = board.getSize();
        int sqrtN = (int) Math.sqrt(N);
        int startRow = (subgridIndex / sqrtN) * sqrtN;
        int startCol = (subgridIndex % sqrtN) * sqrtN;
        boolean[] used = new boolean[N + 1];

        for (int row = 0; row < sqrtN; row++) {
            for (int col = 0; col < sqrtN; col++) {
                int num = board.getValueAt(startRow + row, startCol + col);
                if (num != 0) {
                    if (used[num]) {
                        return false;
                    }
                    used[num] = true;
                }
            }
        }

        return true;
    }
}
