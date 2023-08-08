package Test;

import Main.BacktrackingSudokuSolver;
import Main.SudokuBoard;
import Main.SudokuValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import Main.SudokuSolver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class SudokuSolverTest {
    private SudokuSolver solver;
    private SudokuValidator validator;
    private int[][] validBoard;
    private int[][] invalidBoard;

    @BeforeEach
    public void setUp() {
        solver = new BacktrackingSudokuSolver();
        validator = new SudokuValidator();

        // Create valid and invalid Sudoku boards for testing
        validBoard = new int[][] {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        invalidBoard = new int[][] {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 7} // Invalid: two 7's in the last row
        };
    }

    @Test
    public void testValidSudoku() {
        SudokuBoard board = new MockSudokuBoard(validBoard);
        Assertions.assertTrue(validator.isValidSudoku(board));
        Assertions.assertTrue(solver.solveSudoku(board));
    }

    @Test
    public void testInvalidSudoku() {
        SudokuBoard board = new MockSudokuBoard(invalidBoard);
        Assertions.assertFalse(validator.isValidSudoku(board));
        Assertions.assertFalse(solver.solveSudoku(board));
    }
}
