package Main;

public class VariableSizeSudokuIterator implements SudokuIterator {
    private SudokuBoard board;
    private int size;
    private int currentRow;
    private int currentCol;

    public VariableSizeSudokuIterator(SudokuBoard board) {
        this.board = board;
        this.size = board.getSize();
        this.currentRow = 0;
        this.currentCol = -1;
        moveToNextCell();
    }

    @Override
    public boolean hasNext() {
        return currentRow < size;
    }

    @Override
    public int next() {
        int value = board.getValueAt(currentRow, currentCol);
        moveToNextCell();
        return value;
    }

    private void moveToNextCell() {
        do {
            currentCol++;
            if (currentCol == size) {
                currentCol = 0;
                currentRow++;
            }
        } while (currentRow < size && board.getValueAt(currentRow, currentCol) == 0);
    }
}
