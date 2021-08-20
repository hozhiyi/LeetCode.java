package _202108_AugustLeetCodingChallenge;

public class _36_ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][10];
        int[][] col = new int[9][10];
        int[][] box = new int[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int curNum = board[i][j] - '0';
                System.out.println(curNum);
                if (row[i][curNum] == 1) {
                    return false;
                }
                if (col[j][curNum] == 1) {
                    return false;
                }
                if (box[j / 3 + (i / 3) * 3][curNum] == 1) {
                    return false;
                }
                row[i][curNum] = 1;
                col[j][curNum] = 1;
                box[j / 3 + (i / 3) * 3][curNum] = 1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board =
                {{'5' , '3' , '.' , '.' , '7' , '.' , '.' , '.' , '.'}
                        , {'6' , '.' , '.' , '1' , '9' , '5' , '.' , '.' , '.'}
                        , {'.' , '9' , '8' , '.' , '.' , '.' , '.' , '6' , '.'}
                        , {'8' , '.' , '.' , '.' , '6' , '.' , '.' , '.' , '3'}
                        , {'4' , '.' , '.' , '8' , '.' , '3' , '.' , '.' , '1'}
                        , {'7' , '.' , '.' , '.' , '2' , '.' , '.' , '.' , '6'}
                        , {'.' , '6' , '.' , '.' , '.' , '.' , '2' , '8' , '.'}
                        , {'.' , '.' , '.' , '4' , '1' , '9' , '.' , '.' , '5'}
                        , {'.' , '.' , '.' , '.' , '8' , '.' , '.' , '7' , '9'}};
        System.out.println(isValidSudoku(board));
    }
}
