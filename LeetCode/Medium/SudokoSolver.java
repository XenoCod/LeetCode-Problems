public class SudokoSolver {
    static void sudokoSolve(char board[][]){
        solve(board);
    }
    static boolean solve(char board[][]){
        for(int i=0; i< board.length; i++){
            for(int j=0; j< board[0].length; j++){
                if(board[i][j]=='.'){//only enter when found an empty space
                    for(char c='1'; c<='9'; c++){
                        if(isValid(board, i, j, c)) {
                            board[i][j] = c;

                            if (solve(board)) return true;// fully solved now return back
                            else board[i][j] = '.';//backtrack keeping the value
                        }

                    }
                    return false;
                }

            }
        }
        return true;
    }
    private static boolean isValid(char board[][], int row, int col, char c){
        for(int i=0; i< 9; i++){
            if(board[row][i]==c) return false;//check for each coloum with the char c
            if(board[i][col]== c) return false;//check for each row with thr char c
            if(board[3 * (row/3)+ i / 3] [3 * (col/3) +  i % 3]==c) return false;//check for the subboxes with the char c
        }
        return true;//if all the above condotion are not returned that means we can insert the charcater int the specified pos
    }
    public static void main(String[] args) {
        char board[][]= {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        sudokoSolve(board);
        for(char i[]: board) {
            for (char j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }
}
