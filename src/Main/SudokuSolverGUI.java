package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class SudokuSolverGUI extends JFrame {
    private JTextField[][] cells;
    private JButton solveButton;

    int boardSize = getBoardSizeFromUser();

    public SudokuSolverGUI() {
        setTitle("Sudoku Solver");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new GridLayout(boardSize + 1, boardSize));


        cells = new JTextField[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                cells[i][j] = new JTextField(1);
                add(cells[i][j]);
            }
        }

        solveButton = new JButton("Solve");
        int finalBoardSize = boardSize;
        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                solveSudoku(boardSize);
            }
        });

        add(solveButton);
    }

    private void solveSudoku(int boardSize) {
        SudokuBoard board = new VariableSizeSudokuBoard(boardSize);


        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                String cellValue = cells[i][j].getText();
                int value = 0;
                if (!cellValue.isEmpty()) {
                    try {
                        value = Integer.parseInt(cellValue);
                    } catch (NumberFormatException e) {
                        // Handle invalid input
                        JOptionPane.showMessageDialog(this, "Invalid input: " + cellValue);
                        return;
                    }
                }
                board.setValueAt(i, j, value);
            }
        }
        BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
        // Call the Sudoku solver to solve the puzzle
        if (solver.solveSudoku(board)) {
            // Update the GUI with the solved Sudoku board
            for (int i = 0; i < boardSize; i++) {
                for (int j = 0; j < boardSize; j++) {
                    cells[i][j].setText(String.valueOf(board.getValueAt(i, j)));
                }
            }
            JOptionPane.showMessageDialog(this, "Sudoku solved!");
        } else {
            JOptionPane.showMessageDialog(this, "No solution exists.");
        }
    }

    private static int getBoardSizeFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the board size (e.g., 4 for a 4x4 Sudoku, 9 for a 9x9 Sudoku): ");
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SudokuSolverGUI gui = new SudokuSolverGUI();
            gui.setVisible(true);
        });
    }
}

