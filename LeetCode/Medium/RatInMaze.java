import java.util.ArrayList;

public class RatInMaze {
    static ArrayList<String > ratMaze(int maze[][], int n){
        //we will move ahead only if the maze entry is possible
        ArrayList<String> res= new ArrayList<>();
        boolean visited [][]= new boolean[n][n];
        if(maze[0][0]==1) solve(res, maze, visited, new StringBuilder(), n, 0, 0);
        return res;
    }
    static void solve(ArrayList<String> res, int maze[][],boolean visited[][], StringBuilder path, int n, int row, int cols){
        if(row == n-1 && cols == n-1){
            res.add(path.toString());
            return;
        }

        //Since it is asked to print in lexiograhical order so we move as DLRU

        //Downward
        if( row+1 < n && maze[row+1][cols] == 1 && !visited[row+1][cols] ){
            visited[row][cols]=true;
            solve(res, maze, visited, path.append("D"), n, row+1, cols);
            visited[row][cols]=false;
            path.deleteCharAt(path.length()-1);

        }
        //left
        if(cols-1>=0 && maze[row][cols-1]==1 && !visited[row][cols-1]){
            visited[row][cols]=true;
            solve(res,maze, visited, path.append("L"), n, row, cols-1);
            visited[row][cols]=false;
            path.deleteCharAt(path.length()-1);
        }
        //Right
        if(cols+1<n && maze[row][cols+1]==1 && !visited[row][cols+1]){
            visited[row][cols]=true;
            solve(res, maze, visited, path.append("R"), n , row, cols+1);
            visited[row][cols]=false;
            path.deleteCharAt(path.length()-1);
        }
        //Up
        if(row-1>=0 && maze[row-1][cols]==1 && !visited[row-1][cols]){
            visited[row][cols]=true;
            solve(res, maze, visited, path.append("U"), n, row-1, cols);
            visited[row][cols]=false;
            path.deleteCharAt(path.length()-1);
        }
    }
    public static void main(String[] args) {
        int n = 4;
        int m[][] = {{1, 0, 0, 0},
                    {1, 1, 0, 1},
                    {1, 1, 0, 0},
                    {0, 1, 1, 1}};
        System.out.println(ratMaze(m, n));
    }
}
