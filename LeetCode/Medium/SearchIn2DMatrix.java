public class SearchIn2DMatrix {
    static boolean searchMatrix(int [][] matrix, int target){
        if(matrix.length==0) return false;
        int rows= matrix.length, cols= matrix[0].length;
        int low= 0, high= (rows * cols)-1;
        while(low<=high){
            int mid= low+ (high- low)/2;
            if(matrix[mid/4][mid%4]==target) return true;
            else if(matrix[mid/4][mid%4]> target) high= mid-1;
            else low= mid+1;

        }
        return false;
    }
    public static void main(String[] args) {
        int matrix[][]= {{1,3,5,7}, {10, 11, 16, 20}, {23,30, 34, 60}};
        int target= 8;
        System.out.println(searchMatrix(matrix,target ));
    }
}
