public class BingoBoard {
    int[][] board;
    boolean[][] markedNumbers;
    boolean bingo;

    public BingoBoard(int[] array) {
        board = new int[5][5];
        markedNumbers = new boolean[5][5];
        bingo = false;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = array[i * 5 + j];
            }
        }
    }

    public boolean getBingo() {
        return bingo;
    }

    public void print() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] / 10 == 0) {
                    System.out.print(" ");
                }
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean setClear(int num) {
        int rowNumber = 0;
        int columnNumber = 0;
        for (rowNumber = 0; rowNumber < 5; rowNumber++) {
            for (columnNumber = 0; columnNumber < 5; columnNumber++) {
                if (board[rowNumber][columnNumber] == num) {
                    markedNumbers[rowNumber][columnNumber] = true;
                    //print();
                    return bingoCheck(columnNumber, rowNumber);

                }
            }
        }
        return false;
    }

    public boolean bingoCheck(int columnNumber, int rowNumber) {
        if (checkColumn(columnNumber)) {
            bingo = true;
            return true;
        }
        if (checkRow(rowNumber)) {
            bingo = true;
            return true;
        }
        /*
        if (checkLeftDiagonal()) {
            bingo = true;
            return true;
        }
        if (checkRightDiagonal()) {
            bingo = true;
            return true;
        } 
        */
        return false;
    }

    private boolean checkColumn(int columnNumber) {
        for (int y = 0; y < 5; y++) {
            if (!markedNumbers[y][columnNumber]) {
                return false;
            }
        }
        return true;
    }

    private boolean checkRow(int rowNumber) {
        for (int x = 0; x < 5; x++) {
            if (!markedNumbers[rowNumber][x]) {
                return false;
            }
        }
        return true;
    }

    // **
    private boolean checkLeftDiagonal() {
        for (int i = 0; i < 5; i++) {
            if (!markedNumbers[i][i]) {
                return false;
            }
        }
        return true;
    }

    private boolean checkRightDiagonal() {
        for (int i = 0; i < 5; i++) {
            if (!markedNumbers[i][4 - i]) {
                return false;
            }
        }
        return true;
    }

    public int sumOfUnmarkedNumbers() {
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (!markedNumbers[i][j]) {
                    sum += board[i][j];
                }
            }
        }
        return sum;
    }

}