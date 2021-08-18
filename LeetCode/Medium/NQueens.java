import java.util.ArrayList;

public class NQueens {
    static ArrayList<ArrayList<String>> nQueens(int n){
        ArrayList<ArrayList<String>> res= new ArrayList<>();
        char board[][]= new char[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j < n;j++)
                board[i][j]='.';
        int leftRow[]= new int [n];
        int upperDiagonal[]= new int[(2 * n)-1];
        int lowerDiagonal[]= new int [(2 * n)-1];
        solve(res, board, leftRow, lowerDiagonal, upperDiagonal,n, 0 );
        return res;

    }
    static void solve(ArrayList<ArrayList<String>> res, char board[][],  int leftRow[], int lowDiagonal[], int upperDiagonal[], int n, int cols ){
        if(cols == n){
            res.add(0,addBoard(board));
            return;
        }
        for(int rows=0; rows< n; rows++){
            if(leftRow[rows] == 0 && lowDiagonal[rows + cols]==0 && upperDiagonal[(board.length-1)+ (cols - rows)] == 0){
                board[rows][cols]='Q';
                leftRow[rows] = 1;
                lowDiagonal[rows + cols]=1;
                upperDiagonal[(n-1)+ (cols - rows)]=1;
                solve(res, board, leftRow, lowDiagonal, upperDiagonal, n, cols+1);
                board[rows][cols]='.';
                leftRow[rows] = 0;
                lowDiagonal[rows + cols]=0;
                upperDiagonal[(n-1)+ (cols - rows)]=0;

            }
        }
    }
    static ArrayList<String> addBoard(char board[][]){
        ArrayList<String> res= new ArrayList<>();
        for(int i=0;i<board.length;i++)
            res.add(new String(board[i]));
        return res;
    }
    public static void main(String[] args) {
        int n= 4;
        System.out.println(nQueens(n));
    }
}


//[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
