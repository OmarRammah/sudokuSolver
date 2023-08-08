package Main;

public interface SudokuBoard {
    int getSize();
    int getValueAt(int row, int col);
    void setValueAt(int row, int col, int value);

    SudokuIterator iterator();
}

