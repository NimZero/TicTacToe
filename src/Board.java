public class Board {
    private Character[] board;

    public Board() {
        this.board = new Character[9];
    }

    public void setBoard(Character[] board) {
        if(board.length != 9) throw new IllegalArgumentException("Must be a char array of length 10.");
        this.board = board;
    }

    public boolean play(int index, char symbol) {
        if(index < 0 || index > 8) throw new ArrayIndexOutOfBoundsException();
        if(board[index]!=null) return false;
        board[index] = symbol;
        return true;
    }

    public void reset() {
        board = new Character[9];
    }

    public void print() {
        for (int i = 0; i < 9; i++) {
            char sym;
            if(board[i]!=null) {
                sym = board[i];
            }else {
                sym = ' ';
            }
            System.out.print(" "+sym+" ");
            if(i==2 || i==5) {
                System.out.print("\n\u2500\u2500\u2500\u253c\u2500\u2500\u2500\u253c\u2500\u2500\u2500\n");
            }else if(i!=8){
                System.out.print('\u2502');
            }
        }
        System.out.println();
    }

    public boolean testRows() {
        for (int rowIndex = 0; rowIndex < 3; rowIndex++) {
            if(board[(rowIndex * 3)] == board[1 + (rowIndex * 3)] && board[1 + (rowIndex * 3)] == board[2 + (rowIndex * 3)] && board[(rowIndex * 3)] != null) return true;
        }
        return false;
    }

    public boolean testCols() {
        for (int colIndex = 0; colIndex < 3; colIndex++) {
            if(board[colIndex] == board[3 + colIndex] && board[3 + colIndex] == board[6 + colIndex] && board[colIndex] != null) return true;
        }
        return false;
    }

    public boolean testDiags() {
        return board[4] != null && (board[0] == board[4] && board[4] == board[8] || board[2] == board[4] && board[4] == board[6]);
    }

    public boolean testVictory() {
        return testCols() || testRows() || testDiags();
    }
}