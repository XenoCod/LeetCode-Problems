public class WordSearch {
    static boolean searchWord(char board[][], String word){
        for(int i=0; i< board.length; i++)
            for(int j=0; j< board[0].length; j++)
                if(word.charAt(0) == board[i][j] && solve(board, word, i, j , 0 ))
                    return true;
       return false;
    }
    private static boolean solve(char board[][], String word, int i, int j, int index){
       if(index == word.length())
           return true;
       if(i< 0 || i>= board.length || j>= board[0].length || j<0 || word.charAt(index) != board[i][j])
           return false;
       board[i][j]='*';
       boolean res= solve(board, word, i+1, j, index+1) ||
                    solve(board, word, i, j+1, index+1) ||
                    solve(board, word, i-1, j, index+1)||
                    solve(board, word, i, j-1, index+1);
       board[i][j]= word.charAt(index);
       return res;
    }
    public static void main(String[] args) {
       char board[][]= {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}; String word = "ABCCED";
        System.out.println(searchWord(board, word));
    }
}
