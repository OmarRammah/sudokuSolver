## Sudoku Solver:
This program is a Sudoku Solver that allows the user to input an unsolved sudoku, and will solve it if it is solvable; if not, it notifies the user. The program works for Sudoku's of different sizes and allows the user to input their desired size. Currently, this program implements a recursive method of solving Sudoku's called the Backtracking Algorithm, but can be easily extended to implement others if desired. The program can be run from the SudokuSolverGUI class.



# Design Patterns:
Strategy Design Pattern: This program implements the strategy design pattern. Because we can have multiple strategies of solving a Sudoku, we have a class called SudokuSolver, and the different strategies are in separate subclasses. This is the strategy design pattern since all these classes solve the same problem but with different methods.

Iterator Design Pattern: This program also uses the iterator design pattern, as it often iterates over the sudoku board, so an iterator was implemented to the SudokuBoard class, to simplify this.



# CA/ Code Smells:
There are no overt code smells or violations of Clean Architecture, however, there are some SOLID principles that are not applicable and thus are not implemented in the program.

Java Version: openjdk-18.0.2.1
Testing Framework: JUnit 5.8.1
